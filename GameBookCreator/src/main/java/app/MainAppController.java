package app;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
import model.Chapter;
import utils.ContentProcessor;
import utils.FileOperator;

public class MainAppController implements Initializable {

    @FXML
    private TreeView treeView;
    @FXML
    private TreeItem chaptersTreeItem;
    @FXML
    private TextArea contentTextArea;
    @FXML
    private Label infoLabel;

    @FXML
    private TableView<Chapter> linksTableView;
    @FXML
    private TableColumn<Chapter, String> nrColumn;
    @FXML
    private TableColumn<Chapter, String> flagColumn;
    @FXML
    private TableColumn<Chapter, String> titleColumn;

    //chapter's list
    private List<Chapter> data = new ArrayList<>();
    // links list
    private ObservableList<Chapter> links = FXCollections.observableArrayList();

    //initialize index of selected tree item
    private int selectedIndex = -1;
    //store selected ratiobutton in Dialog popup edit/new window
    private RadioButton radioButtonSelected;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //add temp data
        data.add(new Chapter(Flags.START, "Begin f: "));
        data.get(0).setFixed(true);     //1-th chapter fixed
        data.add(new Chapter(Flags.READY, "Ordinary chapter f: "));
        data.add(new Chapter(Flags.DEAD, "Dead man f: "));
        data.add(new Chapter(Flags.END, "Fixed f: "));
        data.get(3).setFixed(true);     //4-th chapter fixed
        data.add(new Chapter(Flags.WIN, "Win at last! f: "));
        data.add(new Chapter(Flags.TODO, "So much to do! f: "));

        //ustaw kolumny links list
        nrColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        flagColumn.setCellValueFactory(new PropertyValueFactory<>("flag"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        //ustaw wyswietlanie tabeli
        linksTableView.setItems(links);

        //listener F2 na content Textarea
        contentTextArea.setOnKeyPressed((e) -> {
            if (e.getCode() == KeyCode.F2) {
                contentTextArea.setText(contentTextArea.getText() + " {ch:new}");
                contentTextArea.positionCaret(contentTextArea.getText().length());
            }
        });

        //listener na treeview chapterow
        treeView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> getSelectedItem(newValue));

        //set default temporary selected radiobutton value
        radioButtonSelected = new RadioButton("TODO");

        //refresh tree
        refreshTeeView();
    }

    @FXML
    public void openFileAction() {

        FileChooser fileChooser = new FileChooser();
        //set title
        fileChooser.setTitle("Open");
        //set ext filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("GameBook Data (*.gbd)", "*.gbd");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(treeView.getParent().getScene().getWindow());

        if (file != null) {
            List<Chapter> newList = FileOperator.loadData(file);
            if (newList != null) {
                data.clear();
                data = newList;
            }
        }

        Chapter.setCount(data.size());        
        refreshTeeView();
    }

    @FXML
    public void saveFileAction() {

        FileChooser fileChooser = new FileChooser();
        //set title
        fileChooser.setTitle("Save");
        //set ext filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("GameBook Data (*.gbd)", "*.gbd");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(treeView.getParent().getScene().getWindow());

        if (file != null) {
            FileOperator.saveData(data, file);
        }

    }

    @FXML
    public void quitAciton() {
        System.exit(0);
    }

    @FXML
    public void addNewChapterAction() throws IOException {

        //set dialog window of type chapter
        Dialog<Chapter> dialog = new Dialog<>();
        dialog.setTitle("Add new chapter");
        dialog.setHeaderText("Edit all necessary fields.");
        dialog.setGraphic(new ImageView(this.getClass().getResource("/icons/16/new.png").toString()));

        //draw form from fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DialogWindow.fxml"));
        loader.setController(new DialogController());
        Parent root = loader.load();
        dialog.getDialogPane().setContent(root);
        DialogController dialogController = loader.getController();

        //reset radiobutton value
        radioButtonSelected.setText("TODO");

        //add listener to radiobutton toggle group
        dialogController
                .getToggleGroup()
                .selectedToggleProperty().addListener(
                        (ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {
                            if (dialogController
                            .getToggleGroup()
                            .getSelectedToggle() != null) {
                                radioButtonSelected = (RadioButton) newToggle.getToggleGroup().getSelectedToggle();
                            }
                        });

        // Request focus on the username field by default.
        Platform.runLater(() -> dialogController.getTitleSmall().requestFocus());
        //end form

        // Set the button types.
        ButtonType addButtonType = new ButtonType("Add", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        //what return from popup dialog window
        dialog.setResultConverter(dialogButton -> {

            Chapter ch = new Chapter();
            ch.setFixed(dialogController.getFixedChBox().selectedProperty().getValue());
            ch.setFlag(setNewFlagFromRadioButton(radioButtonSelected)); //add flag
            ch.setTitle(dialogController.getTitleSmall().getText());

            if (dialogButton == addButtonType) {
                return ch;
            }
            return null;
        });

        //wait and return temp chapter
        Optional<Chapter> result = dialog.showAndWait();

        result.ifPresent(chapter -> {
            data.add(new Chapter(chapter.isFixed(), chapter.getFlag(), chapter.getTitle()));
        });

        refreshTeeView();
        
        //test
        data.forEach(System.out::println);
        System.out.println("\n");

    }

    @FXML
    public void editChapterAction() throws IOException {
        if (selectedIndex >= 0) {

            //ustaw parametry okna dialogowego
            Dialog<Chapter> dialog = new Dialog<>();
            dialog.setTitle("Edit chapter " + data.get(selectedIndex).getNumber());
            dialog.setHeaderText("Edit all necessary fields.");
            dialog.setGraphic(new ImageView(this.getClass().getResource("/icons/16/edit.png").toString()));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DialogWindow.fxml"));
            loader.setController(new DialogController());
            Parent root = loader.load();
            dialog.getDialogPane().setContent(root);
            DialogController dialogController = loader.getController();

            dialogController
                    .getTitleSmall()
                    .setText(data.get(selectedIndex).getTitle());
            dialogController
                    .getFixedChBox()
                    .selectedProperty()
                    .setValue(data.get(selectedIndex).isFixed());
            radioButtonSelected.setText(data.get(selectedIndex).getFlag().toString());

            //
            dialogController
                    .getToggleGroup()
                    .selectedToggleProperty().addListener(
                            (ObservableValue<? extends Toggle> ov, Toggle oldToggle, Toggle newToggle) -> {
                                if (dialogController
                                .getToggleGroup()
                                .getSelectedToggle() != null) {
                                    radioButtonSelected = (RadioButton) newToggle.getToggleGroup().getSelectedToggle();
                                }
                            });

            // Request focus on the username field by default.
            Platform.runLater(() -> dialogController.getTitleSmall().requestFocus());

            //end form
            // Set the button types.
            ButtonType addButtonType = new ButtonType("Add", ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

            //wybierz, co zwrócić z okna dialogowego
            dialog.setResultConverter(dialogButton -> {

                Chapter ch = new Chapter();
                ch.setFixed(dialogController.getFixedChBox().selectedProperty().getValue());
                ch.setFlag(setNewFlagFromRadioButton(radioButtonSelected)); //add flag
                ch.setTitle(dialogController.getTitleSmall().getText());

                if (dialogButton == addButtonType) {
                    return ch;
                }
                return null;
            });

            //czekaj na efekt i zwróc obiekt Chapter
            Optional<Chapter> result = dialog.showAndWait();

            result.ifPresent(chapter -> {
                data.get(selectedIndex).setTitle(chapter.getTitle());
                if (selectedIndex > 0) {
                    data.get(selectedIndex).setFlag(chapter.getFlag());
                    data.get(selectedIndex).setFixed(chapter.isFixed());
                }
            });

            refreshTeeView();

        } else {
            showAlertDialog("Chapter not selected. Select chapter.");
        }

    }

    @FXML
    public void deleteChapterAction() {
        if (selectedIndex > 0) {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Are you ok with this?");
            alert.setGraphic(new ImageView(this.getClass().getResource("/icons/16/delete.png").toString()));
            alert.setContentText("Delete chapter: " + data.get(selectedIndex).toString() + "?\n"
                    + "Can't be undone!");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                data.remove(selectedIndex);
                selectedIndex = -1;
                refreshTeeView();
                showInfo("Chapter deleted");
            } else {
                // ... user chose CANCEL or closed the dialog
                showInfo("Canceled");
            }

        } else if (selectedIndex == 0) {
            showAlertDialog("Can't delete first chapter.");
        } else {
            showAlertDialog("Chapter not selected. Select chapter.");
        }
    }

    @FXML
    public void shuffleChaptersAction() {
        shuffleChapters(data);
        refreshTeeView();
    }

    @FXML
    public void addContentToChapter() {
        if (selectedIndex >= 0) {
            data.get(selectedIndex).setContent(contentTextArea.getText());
            List<Integer> linkChapters = ContentProcessor.processContent(contentTextArea.getText());
            int tempSelected = selectedIndex;

            //obrabiaj listę linków
            //TODO: 
            links.clear();
            //add temp data
            if (linkChapters != null) {
                for (Integer i : linkChapters) {

                    if (i > data.get(data.size() - 1).getNumber()) {
                        System.out.println("tu macz");                        
                    } else if (i < 1) {
                        System.out.println("0 to za mało, zero to za mało");  
                    } else {
//                        links.add(data.get(i - 1));
                    }
                }
            }
        } else {
            showAlertDialog("Chapter not selected. Select chapter.");
        }

    }

//*************************************************************
//                      other methods
//*************************************************************
    private void getSelectedItem(Object newValue) {
        TreeItem<String> selectedItem = (TreeItem<String>) newValue;
        if (selectedItem.getParent() != null && selectedItem.isLeaf()) {

            selectedIndex = selectedItem.getParent().getChildren().indexOf(newValue);
            showInfo("Index " + selectedIndex + " " + selectedItem.getValue() + " selected.");
            contentTextArea.setText(data.get(selectedIndex).getContent());

        } else {
            showInfo("Select chapter...");
            selectedIndex = -1;
        }
    }

    private void refreshTeeView() {
        chaptersTreeItem.getChildren().clear();
        for (Chapter c : data) {
            String info = "[" + c.getNumber() + "] " + c.getTitle() + " " + c.isFixed();

            Image image = new Image(getClass().getResourceAsStream("/icons/16/ready.png"));

            switch (c.getFlag()) {
                case START:
                    image = new Image(getClass().getResourceAsStream("/icons/16/start.png"));
                    break;
                case DEAD:
                    image = new Image(getClass().getResourceAsStream("/icons/16/dead.png"));
                    break;
                case END:
                    image = new Image(getClass().getResourceAsStream("/icons/16/end.png"));
                    break;
                case WIN:
                    image = new Image(getClass().getResourceAsStream("/icons/16/win.png"));
                    break;
                case TODO:
                    image = new Image(getClass().getResourceAsStream("/icons/16/todo.png"));
                    break;
                default:
                    image = new Image(getClass().getResourceAsStream("/icons/16/ready.png"));
                    break;
            }

            TreeItem<String> empLeaf = new TreeItem<>(info, new ImageView(image));

            chaptersTreeItem.getChildren().add(empLeaf);
        }
        selectedIndex = -1;
    }

    private void showAlertDialog(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(message);
        alert.showAndWait();
    }

    private void showInfo(String msg) {
        infoLabel.setText(msg);
    }

    private Flags setNewFlagFromRadioButton(RadioButton radioButtonSelected) {
        switch (radioButtonSelected.getText()) {
            case "TODO":
                return Flags.TODO;
            case "START":
                return Flags.START;
            case "DEAD":
                return Flags.DEAD;
            case "END":
                return Flags.END;
            case "WIN":
                return Flags.WIN;
            case "READY":
                return Flags.READY;
            default:
                return Flags.TODO;
        }
    }

    private void shuffleChapters(List<Chapter> chapters) {

        List<Chapter> shuff = new ArrayList<>();
        int counter = 0;

        for (Chapter c : data) {
            if (!c.isFixed()) {
                shuff.add(c);
            }
        }

        Collections.shuffle(shuff);

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).isFixed()) {
                //do nothing
            } else {
                data.set(i, shuff.get(counter));
                counter++;
            }
        }

        counter = 0;

        for (Chapter c : data) {
            c.setNumber(++counter);
        }

    }

}

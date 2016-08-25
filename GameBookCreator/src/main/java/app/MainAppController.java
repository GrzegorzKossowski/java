package app;

import model.Chapter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainAppController implements Initializable {

    @FXML
    private TableView<Chapter> chaptersTableView;
    @FXML
    private TableColumn<Chapter, String> idColumn;
    @FXML
    private TableColumn<Chapter, String> flagColumn;
    @FXML
    private TableColumn<Chapter, String> titleColumn;

    @FXML
    private TextField titleTextField;
    @FXML
    private TextArea contentTextArea;
    
    final ObservableList<Chapter> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        flagColumn.setCellValueFactory(new PropertyValueFactory<>("flag"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        data.add(new Chapter(1, "End", "Tytul"));
        data.add(new Chapter(2, "", "Attack"));
        
        chaptersTableView.setItems(data);
        chaptersTableView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> getSelectedItem(newValue));

    }

    @FXML
    public void quitAciton() {
        System.exit(0);
    }

    private void getSelectedItem(Object newValue) {

        Chapter chapter = new Chapter();
        chapter = (Chapter) newValue;
        
        System.out.println(chapter.getTitle());
        titleTextField.setText(chapter.getTitle());
        contentTextArea.setText(chapter.getTitle());
        
        

    }

}

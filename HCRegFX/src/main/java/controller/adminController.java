package controller;

import app.EPriviledges;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DBUser;
import util.FormController;
import util.HibernateController;

public class adminController implements Initializable {

    /**
     * Glowny kontener okna
     */
    @FXML
    private VBox mainRoot;    
    /**
     * Tablica uzytkownikow systemu
     */
    @FXML
    private TableView<DBUser> tableView;
    /**
     * Kolumna loginow uzytkownikow systemu
     */
    @FXML
    private TableColumn<DBUser, String> loginColumn;
    /**
     * Kolumna poziomu dostepu uzytkownika
     */
    @FXML
    private TableColumn<DBUser, Integer> privColumn;
    /**
     * Kolumna opisu uzytkownika
     */
    @FXML
    private TableColumn<DBUser, String> descColumn;
    /**
     * Pole wpisu loginu nowego uzytkownika
     */
    @FXML
    private TextField loginTextField;
    /**
     * Pole wpisu hasla nowego uzytkownika
     */
    @FXML
    private PasswordField passwdField;
    /**
     * Pole opisu nowego uzytkownika
     */
    @FXML
    private TextArea descTextArea;
    /**
     * Combo wybour poziomu dostepu do bazy
     */
    @FXML
    private ComboBox privComboBox;
    /**
     * Button dodawania nowego uzytkownika
     */
    @FXML
    private Button addUserBtn;

    //others
    /**
     * Tymczasowy uzytkowink
     */
    private DBUser tmpUser;

    /**
     * Lista uzytkowikow pobranych z bazy do wyswietlenia w tabeli
     */
    final ObservableList<DBUser> data = FXCollections.observableArrayList();
    //final ObservableList<String> privBox = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //priviledge lvl
        privComboBox.getItems().addAll(EPriviledges.ADMIN.getValue(),
                EPriviledges.DOCTOR.getValue(),
                EPriviledges.USER.getValue());
        privComboBox.valueProperty().setValue("----");

        //table columns
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        //privColumn.setCellValueFactory(new PropertyValueFactory<DBUser, Integer>("priviledge"));
        privColumn.setCellValueFactory(new PropertyValueFactory<>("priviledge"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        //table data
        data.addAll(HibernateController.fillTableView());
        tableView.setItems(data);

        tableView.getSelectionModel().selectedItemProperty().addListener((observable,
                oldValue, newValue) -> getUserSelected(newValue));

    }

    @FXML
    public void logoutAction() {

        //give me login window
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Stage stage = (Stage) mainRoot.getScene().getWindow();
            stage.setTitle("HCRegFX - Login");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
        }

    }

    @FXML
    public void quitAction() {

        System.exit(0);

    }

    @FXML
    public void addNewUser() {

        //login=8+, passwd=any, combo=chosen
        if (FormController.validateLogin(loginTextField.getText())
                && FormController.validatePassword(passwdField.getText())
                && FormController.validateTextArea(descTextArea.getText())
                && FormController.validateComboBox(privComboBox.getValue())) {

            //TODO: poprawic validacje comboBox
            int prv = FormController.getPrivFromComboBox(privComboBox.getValue().toString());

            System.out.println("validation OK");
            DBUser user = new DBUser(loginTextField.getText(), passwdField.getText(),
                    prv, descTextArea.getText());
            System.out.println(user.toString());

            HibernateController.addNewUser(user);
            data.add(user);
            loginTextField.setText("");
            passwdField.setText("");
            descTextArea.setText("");
            privComboBox.setValue("----");

        } else {
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add new user");
            alert.setHeaderText(null);
            alert.setContentText("Fill all form fields properly.");
            alert.showAndWait();
            
        }

    }

    @FXML
    public void deleteUser() {

        if (tmpUser != null) {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Deleting user");
            alert.setHeaderText("Delete user from DB");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {

                if (HibernateController.deleteUser(tmpUser)) {

                    System.out.println("HB delete OK");
                    data.remove(tableView.getSelectionModel().getSelectedIndex());

                } else {

                    //TODO: more info na temat bledu
                    System.out.println("Can't remove from DB");

                }

            } else {
                System.out.println("Cancel");
            }

        } else {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Deleting user");
            alert.setHeaderText(null);
            alert.setContentText("Select user from Table first.");
            alert.showAndWait();

        }

    }

    private void getUserSelected(DBUser selectedUser) {
        
        tmpUser = selectedUser;
        
    }

}

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

    @FXML
    private VBox mainRoot;
    @FXML
    private TableView<DBUser> tableView;
    @FXML
    private TableColumn<DBUser, String> loginColumn;
    @FXML
    private TableColumn<DBUser, Integer> privColumn;
    @FXML
    private TableColumn<DBUser, String> descColumn;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passwdField;
    @FXML
    private TextArea descTextArea;
    @FXML
    private ComboBox privComboBox;
    @FXML
    private Button addUserBtn;

    //others
    private DBUser tmpUser;

    final ObservableList<DBUser> data = FXCollections.observableArrayList();
    final ObservableList<String> privBox = FXCollections.observableArrayList();

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
            //TODO: info na temat validacji formularza
            System.out.println("info na temat validacji formularza");
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

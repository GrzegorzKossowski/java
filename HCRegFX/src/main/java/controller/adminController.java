package controller;

import app.EPriviledges;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        loginColumn.setCellValueFactory(new PropertyValueFactory<DBUser, String>("login"));
        privColumn.setCellValueFactory(new PropertyValueFactory<DBUser, Integer>("priviledge"));
        descColumn.setCellValueFactory(new PropertyValueFactory<DBUser, String>("description"));

        //table data
        data.addAll(HibernateController.fillTableView());
        tableView.setItems(data);

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
//            
//            HibernateController.addNewUser(user);
//            data.removeAll();
//            data.addAll(HibernateController.fillTableView());

        } else {
            //TODO: info na temat validacji formularza
            System.out.println("bad validation");
        }

    }

}

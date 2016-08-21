package controller;

import app.EPriviledges;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DBUser;
import util.FormController;

public class loginController implements Initializable {

    @FXML
    private Button loginBtn;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLbl;

    private Parent root;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void cancelAction() {

        System.exit(0);

    }

    @FXML
    public void loginAction() {

        String login = loginTextField.getText();
        String passwd = passwordField.getText();

        DBUser user = new DBUser(login, passwd);

        if(FormController.validateLogin(login) &&
                FormController.validatePassword(passwd)) {
            
            //TODO: przeniesc walidacje usera do kontrolera Hibernate
            if (user.dbValidate(login, passwd)) {

                showAppPanel(user.getPriviledge());
                user.setMessage("");
                messageLbl.setText("");
                
            } else {
                
                messageLbl.setText(user.getMessage());
                
            }

        } else {
            
            messageLbl.setText(FormController.getMessage());
            
        }

    }

    private void showAppPanel(int priv) {

        String privValue;
        
        switch(priv) {
            case 0:
                privValue = EPriviledges.ADMIN.getValue();
                break;
            case 1:
                privValue = EPriviledges.DOCTOR.getValue();
                break;
            case 3:
                privValue = EPriviledges.USER.getValue();
                break;            
            default:
                privValue = EPriviledges.USER.getValue();
                break;
        }
        
        System.out.println("/fxml/" + privValue + ".fxml");
        
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/" + privValue + ".fxml"));
            stage = (Stage) loginBtn.getScene().getWindow();
            stage.setTitle("HCRegFX - " + privValue.toUpperCase());
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
        }
    }

}

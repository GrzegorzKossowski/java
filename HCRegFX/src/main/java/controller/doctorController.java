package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class doctorController implements Initializable {

    @FXML
    private VBox mainRoot;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void logoutAction() {
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

}

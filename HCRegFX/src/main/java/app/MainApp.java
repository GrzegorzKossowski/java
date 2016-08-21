package app;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.HibernateUtil;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
//            Parent root = FXMLLoader.load(getClass().getResource("/fxml/admin.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/app.css");

            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
        }

    }

    @Override
    public void stop() throws Exception {
        HibernateUtil.getSessionFactory().close();
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        launch(args);
    }

}

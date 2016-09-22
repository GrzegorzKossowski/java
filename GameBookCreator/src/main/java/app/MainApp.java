/**
 * GameBook Creator
 * Program do tworzenia gamebookow.
 */
package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.stage.Window;

public class MainApp extends Application {


    private Scene scene;
    private Parent root;

    @Override
    public void start(Stage stage) {

        try {

            root = FXMLLoader.load(getClass().getResource("/fxml/MainApp.fxml"));
            scene.getStylesheets().add("/styles/MainApp.css");
            

        } catch (Exception e) {
        }

        scene = new Scene(root, 920, 720);
        stage.setTitle("GameBook Creator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

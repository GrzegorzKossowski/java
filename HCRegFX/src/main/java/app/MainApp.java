/**
 * Health Care Registration 2016
 * 
 * System obslugi przychodni 
 * - obsluga uzytkownikow systemu od strony administracyjnej
 * - dodawanie, edycja i usuwanie pacjentow
 * - zapis i przeglad wizyt pacjenta
 * 
 */
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
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/app.css");

            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) { }

    }

    @Override
    public void stop() throws Exception {
        
        HibernateUtil.getSessionFactory().close();
        super.stop();
        
    }

    public static void main(String[] args) {
        
        launch(args);
        
    }

}

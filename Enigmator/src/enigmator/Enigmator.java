package enigmator;

import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author grze
 */
public class Enigmator extends Application {

    //Stage
    private static Stage stage;
    //Scene
    private Scene scene;
    //Root
    private Parent root;
    
    @Override
    public void start(Stage primaryStage) {
    
        Locale defaultDisplayLocale = Locale.getDefault(Locale.Category.DISPLAY);
        String[] localLang = defaultDisplayLocale.toString().split("_");
                
        setStage(primaryStage);
        
        try {
            //XML view
            
            
            try {
                setRoot(FXMLLoader
                        .load(getClass()
                                .getResource("Enigmator" + localLang[1] + ".fxml")));
                
            } catch (Exception e) {
                //default
                setRoot(FXMLLoader
                        .load(getClass()
                                .getResource("Enigmator.fxml")));
            }
            
            
        } catch (Exception e) {
        }
        // css file
        String cssFile = getClass().getResource("enigmator.css").toExternalForm();
        
        setScene(new Scene(getRoot(), 800, 600));
        getScene().getStylesheets().add(cssFile);
        getStage().setTitle("Enigmator");
        getStage().setScene(getScene());
        getStage().show();
        getStage().resizableProperty().set(false);
        
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Enigmator.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    
    
}

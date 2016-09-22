package app;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainController implements Initializable {

    @FXML
    private Label chapterLbl;
    @FXML
    private Label wordLbl;
    @FXML
    private HBox imagePlaceholder;

    private List<String> names = new ArrayList<>();
    private int counter;
    private int currentChapter;
    private int maxChapters;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView imageView = new ImageView();
        Image mainImage = new Image(MainApp.class.getResourceAsStream("/images/letsgo.png"));
        imageView.setImage(mainImage);
        imagePlaceholder.getChildren().add(imageView);
        
        counter = 0;
        currentChapter = 1;
        chapterLbl.setText("Chapter: " + Integer.toString(currentChapter));
        loadNamesFromXML();
        showImage();
        
        maxChapters = FileProperitesParser.loadMaxChaptersAmount("src/main/resources/properties/setup.properties");
        System.out.println("max " + maxChapters);
    }

    @FXML
    public void quitAction() {
        System.exit(0);
    }

    @FXML
    public void shuffleList() {
        Collections.shuffle(names);        
        counter = 0;        
        showImage();
    }
    
    @FXML
    public void chapterDown() {        
        currentChapter--;
        if(currentChapter<1) currentChapter=maxChapters;
        chapterLbl.setText("Chapter: " + Integer.toString(currentChapter));
        loadNamesFromXML();
    }
    
    @FXML
    public void chapterUp() {
        currentChapter++;
        if(currentChapter>maxChapters) currentChapter=1;
        chapterLbl.setText("Chapter: " + Integer.toString(currentChapter));
        loadNamesFromXML();
    }
    
    
    
    @FXML
    public void loadNamesFromXML() {
        List<String> list = XMLDataParser.getWordsList(Integer.toString(currentChapter));
        names.clear();
        names = list;        
        counter = 0;        
        showImage();        
    }

    @FXML
    public void playSoundAction() {
        URL resource = getClass().getResource("/sounds/ch" + currentChapter + "/" + names.get(counter) + ".mp3");
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        wordLbl.setText(names.get(counter).toUpperCase());
    }

    @FXML
    public void nextItemAction() {
        counter++;
        if (counter > names.size() - 1) {
            counter = 0;
        }
        showImage();
    }

    @FXML
    public void previousItemAcion() {
        counter--;
        if (counter < 0) {
            counter = names.size() - 1;
        }
        showImage();

    }

    private void showImage() {
        wordLbl.setText("");
        imagePlaceholder.getChildren().clear();
        ImageView imageView = new ImageView();
        Image mainImage = new Image(MainApp.class.getResourceAsStream("/images/ch" + currentChapter + "/" + names.get(counter) + ".jpg"));
        imageView.setImage(mainImage);
        imagePlaceholder.getChildren().add(imageView);        
    }
    

}

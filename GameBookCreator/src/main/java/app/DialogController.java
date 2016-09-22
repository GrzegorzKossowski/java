/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author grze
 */
public class DialogController implements Initializable {

    @FXML private TextField titleSmall;
    @FXML private CheckBox fixedChBox;
    @FXML private ToggleGroup toggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        titleSmall.setPromptText("Promptext");
        
    }

    public TextField getTitleSmall() {
        return titleSmall;
    }

    public CheckBox getFixedChBox() {
        return fixedChBox;
    }
    
    public ToggleGroup getToggleGroup() {
        return toggleGroup;
    }
    
    
    @Override
    public String toString() {
        return "DialogController{" + "titleSmall=" + titleSmall + '}';
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigmator;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author grze
 */
public class EnigmatorController implements Initializable {

    @FXML
    private TextArea inputText;
    @FXML
    private TextArea outputText;
    @FXML
    private PasswordField passwordField;
    
    private final Clipboard clipboard = Clipboard.getSystemClipboard();
    private final ClipboardContent content = new ClipboardContent();
   
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void openFileAction() {
        
        FileChooser fileChooser = FileController.getFileChooser("Open");
        File file = fileChooser.showOpenDialog(Enigmator.getStage());
        
        if(file!=null) {
            String txt = FileController.openFile(file);
            if(txt != null) {
                inputText.setText(txt);
            }
        }
        
        
    }
    
    @FXML
    private void saveFileAction() {
        
        FileChooser fileChooser = FileController.getFileChooser("Save");
        File file = fileChooser.showSaveDialog(Enigmator.getStage());
        
        if (file != null) {
            FileController.saveFile(outputText.getText(), file);
        }
        
    }
    
    @FXML
    private void quitAction() {
        System.exit(0);
    }
    
    @FXML
    private void encryptAction() {
        
        String text = inputText.getText();
        String passwd = passwordField.getText();
        String encrypt = MD5Digest.denCrypt(true, text, MD5Digest.getMD5(passwd));
        outputText.setText(encrypt);
        
    }
    
    @FXML
    private void decryptAction() {
        
        String text = inputText.getText();
        String passwd = passwordField.getText();
        String encrypt = MD5Digest.denCrypt(false, text, MD5Digest.getMD5(passwd));
        outputText.setText(encrypt);
        
    }
    
    @FXML
    private void copyAction() {
        
        content.putString(outputText.getText());
        clipboard.setContent(content);
        
    }
    
    @FXML
    private void pasteAction() {
        
        if(clipboard.hasString()) {
            inputText.setText(clipboard.getContent(DataFormat.PLAIN_TEXT).toString());
        } else {
            System.out.println("error!");
        }
        
    }
    
    @FXML
    private void swapAction() {
    
        String tmp = inputText.getText();
        inputText.setText(outputText.getText());
        outputText.setText(tmp);        
    }
    
    @FXML
    private void clearAction() {
        
        inputText.setText("");
        outputText.setText("");        
        
    }
    
    @FXML
    private void aboutAction() {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Enigmator v 1.0.0");
        alert.setContentText("This is a toy. Encryption is NOT fully secure!");
        alert.showAndWait();
        
    }
    
}

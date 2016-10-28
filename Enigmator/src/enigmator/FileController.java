/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigmator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.stage.FileChooser;

/**
 *
 * @author grze
 */
class FileController {

    static FileChooser getFileChooser(String title) {
        
        FileChooser fc = new FileChooser();
        fc.setTitle(title);
              
        FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fc.getExtensionFilters().add(extFilter);
        
        return fc;
    }

    static String openFile(File file) {
    
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder textToRead = new StringBuilder();
        String pathToFile;
        
        try {
            
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String nextLine;
            
            while((nextLine = br.readLine()) != null ) {
                textToRead.append(nextLine);
            }
            
        } catch (Exception e) {
            return null;            
        } finally {
            try {
                if (fr != null) {
                    if (br != null) {
                        br.close();
                        br = null;
                    }
                    fr.close();
                    fr = null;
                }   
            } catch (Exception e) {
                e.getStackTrace();
                return null;
            }
        }
        
        return textToRead.toString();
        
    } // end openfile

    static void saveFile(String textToSave, File file) {
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        String pathToSave;
        
        try {
            
            pathToSave = file.toString();
            String ext = ".txt";
            
            if(!pathToSave.toLowerCase().contains(ext.toLowerCase())) {
                pathToSave += ".txt";
            }
            
            file = new File(pathToSave);
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(textToSave);                    
            
        } catch (Exception e) {
            //System.out.println("save error");                    
        } finally{
            try {
                if (fw != null) {
                    if (bw != null) {
                        bw.close();
                        bw = null;
                    }
                    fw.close();
                    fw = null;
                }                
                
            } catch (Exception e) {
                System.out.println("close file error");
            }
        }
    } // end saveFile
    
}

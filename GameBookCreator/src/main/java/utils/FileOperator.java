/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Chapter;

/**
 *
 * @author grze
 */
public class FileOperator {

    public static List<Chapter> loadData(File file) {

        try {

            // read object from file            
            FileInputStream fis = new FileInputStream(file);

            try (ObjectInputStream ois = new ObjectInputStream(fis)) {

                List<Chapter> list = (List<Chapter>) ois.readObject();
                return list;

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("IOException | ClassNotFoundException e");
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException e");
        }

        return null;

    }

    public static void saveData(List<Chapter> data, File file) {

        String pathToSave = file.toString();
        String ext = ".gbd";
        if (!pathToSave.toLowerCase().contains(ext.toLowerCase())) {
            pathToSave += ext;
        }

        try {

            // write object to file
            FileOutputStream fos = new FileOutputStream(pathToSave);

            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                oos.writeObject(new ArrayList<>(data));

            } catch (IOException ex) {

                Logger.getLogger(FileOperator.class.getName()).log(Level.SEVERE, null, ex);

            }

        } catch (FileNotFoundException e) {
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author grze
 */
public class FileProperitesParser {
    
    public static int loadMaxChaptersAmount(String fileName) {
        
        List<String> props = new ArrayList<>();
        List<String[]> elements = new ArrayList<>();
        String chapterAmount = "1";
        
        try {
            Stream<String> stream = Files.lines(Paths.get(fileName));
            props = stream.filter(line -> line.startsWith("maxchapters"))
                    .collect(Collectors.toList());
//            props.stream().forEach(System.out::println);
            props.stream().forEach((e) -> {
                elements.add(e.split(":"));
            });
                        
        } catch (IOException ex) {
            ex.printStackTrace();            
        }
        
        for(String[] s : elements) {
            if(s[0].equals("maxchapters")) {
                chapterAmount = s[1];
            }
        }
        
        
        return Integer.parseInt(chapterAmount);
    }
    
    
}

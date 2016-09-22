/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author grze
 */
public class ContentProcessor {

    public static List<Integer> processContent(String content) {

        Pattern pattern = Pattern.compile("(\\{ch:\\d+\\})");
        Matcher matcher = pattern.matcher(content);
        List<Integer> list = new ArrayList<>();

        while (matcher.find()) {
            String str = matcher.group();
            str = str.replaceAll("\\{ch:","");
            str = str.replaceAll("\\}","");
            System.out.println(str);
            list.add(Integer.parseInt(str));
        }
        
        System.out.println(list.toString());
        return list;        
    }

}

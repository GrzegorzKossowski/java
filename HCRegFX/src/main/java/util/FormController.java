/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import app.EPriviledges;

/**
 *
 * @author grze
 */
public class FormController {

    public static boolean validateLogin(String login) {

        String pattern = "[\\w+]{8,}";
        return login.matches(pattern);

    }

    public static boolean validatePassword(String passwd) {

        //strong password check [1+ digit, 1+ lower, upper, 1+ special...]
        //String pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
        // temporary simple passwd check
        String pattern = "[\\w]{8,}";
        return passwd.matches(pattern);

    }

    public static boolean validateComboBox(Object value) {

        return !((value == null) || (value.equals("----")));
    }

    public static boolean validateTextArea(String text) {
        return !(text.isEmpty());
    }

    public static Integer getPrivFromComboBox(String value) {

        switch (value) {
            case "admin":
                return 0;
            case "doctor":
                return 1;
            case "user":
                return 2;
            default:
                return 911;
                
        }

    }

}

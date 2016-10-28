/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigmator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author grze
 */
class MD5Digest {
    
    
    public static ArrayList<Integer> getMD5(String passwd) {
        
        String original = passwd;
        MessageDigest md;
        StringBuilder sb = new StringBuilder();
        
        try {
            
            md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException");
        }
        
        original = sb.toString().replaceAll("[a-z]", "");
        
        char[] charArray = original.toCharArray();
        ArrayList<Integer> intList = new ArrayList<>();
        
        for (char c : charArray) {
            intList.add(Character.getNumericValue(c));
        }
        
        if (!intList.isEmpty()) {
            return intList;
        } else {
            return null;
        }        
    } // end getMD4

    public static String denCrypt(boolean enDe, String text, ArrayList<Integer> arrayList) {
        
        StringBuilder sb = new StringBuilder(text);
        int counter = 0;
        
        for (int i=0; i<sb.toString().length(); i++) {
            
            if (counter > arrayList.size() - 1) {
                counter = 0;
            }
            
            if (enDe) {
                sb.setCharAt(i, (char) (sb.charAt(i) + (int) arrayList.get(counter) + 200 ));
            } else {
                sb.setCharAt(i, (char) (sb.charAt(i) - (int) arrayList.get(counter) - 200 ));
            }

        }

        return sb.toString();
    } // end denCrypt
    
    
}

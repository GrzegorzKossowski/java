package com.grze.enigma;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

public class MD5Digest {
		
	public static ArrayList<Integer> getMD5(String passwd) {
		
		String original = passwd;
		MessageDigest md;
		StringBuffer sb = new StringBuffer();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(original.getBytes());
			byte[] digest = md.digest();
			
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
	
/*		System.out.println("original:" + original);
		System.out.println("digested(hex):" + sb.toString());
		System.out.println("digested(no):" + sb.toString().replaceAll("[a-z]", ""));
*/
		original = sb.toString().replaceAll("[a-z]", "");
		
		char[] charArray = original.toCharArray();
		ArrayList<Integer> intList = new ArrayList();
		for(char c : charArray) {
//			System.out.println(c + " " + Character.getNumericValue(c));
			intList.add(Character.getNumericValue(c));
		}
		
		if(intList.size()!=0) {
			return intList;
		} else {
			return null;
		}
		
	}

	public static String encrypt(String string, ArrayList<Integer> arrayList) {
		
		char[] charArray = string.toCharArray();
	
		int counter = 0;	
		
		for(int i=0; i<charArray.length; i++) {
			
			if(counter > arrayList.size()-1) {
				counter = 0;
			}
						
			char temp = charArray[i];
			int charValue = (int) charArray[i];
			charValue += (int) arrayList.get(counter);
			charArray[i] = (char) charValue;			 
			counter++;
			
//			System.out.println(counter + " "
//					+ temp 
//					+ " "
//					+ (int) temp
//					+ " "
//					+ charArray[i]
//					+ (int) charArray[i]
//					+ " "					
//					+ charValue);
			

		}
//		System.out.println(arrayList.toString());
		
		
		return new String().valueOf(charArray);
		
	}
	
public static String decrypt(String string, ArrayList<Integer> arrayList) {
		
		char[] charArray = string.toCharArray();
	
		int counter = 0;	
		
		for(int i=0; i<charArray.length; i++) {
			
			if(counter > arrayList.size()-1) {
				counter = 0;
			}
						
			char temp = charArray[i];
			int charValue = (int) charArray[i];
			charValue -= (int) arrayList.get(counter);
			charArray[i] = (char) charValue;			 
			counter++;
			
//			System.out.println(counter + " "
//					+ temp 
//					+ " "
//					+ (int) temp
//					+ " "
//					+ charArray[i]
//					+ (int) charArray[i]
//					+ " "					
//					+ charValue);
			

		}
//		System.out.println(arrayList.toString());
		
		
		return new String().valueOf(charArray);
		
	}
	
}

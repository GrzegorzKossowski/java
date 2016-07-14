package com.grze.enigma;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileOperator {

	public static void saveFile(String pathToSave, String textToSave) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		BufferedWriter bw = null;
		pathToSave += ".txt";
				
		try {			
			fw = new FileWriter(pathToSave);
			bw = new BufferedWriter(fw);
			bw.write(textToSave);
			
			System.out.println("File saved");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Błąd zapisu: " + e.getMessage());
		} finally {
			try {
				if(fw !=null){
					if(bw!=null) {
						bw.close();
						bw = null;
					}
					fw.close();
					fw = null;
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("error closing file");
			}
		}
		
	}

	public static String loadFile(String pathToLoad) {
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder textToRead = new StringBuilder();
		
		try {			
			file = new File(pathToLoad);
			fr = new FileReader(file);						
			br = new BufferedReader(fr);			
			String nextLine = null;
			
			while((nextLine = br.readLine())!=null) {
				textToRead.append(nextLine);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Błąd odczytu");
			
		} finally {
			try {
				if(fr !=null){
					if(br!=null) {
						br.close();
						br = null;
					}
					fr.close();
					fr = null;
				}				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("error closing file");
			}
		}
		
		return textToRead.toString();
	}
	
}

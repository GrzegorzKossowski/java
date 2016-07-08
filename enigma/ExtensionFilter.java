package com.grze.enigma;

import java.io.File;
import java.io.FileFilter;

public class ExtensionFilter implements FileFilter {

	String[] okFileExtensions = new String[] {"txt", "dat"};
	
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Text files (*.txt, *.dat)";
	}
	
	@Override
	public boolean accept(File f) {

		if (f.isDirectory()) {
            return true;
        }
		for (String extension : okFileExtensions)
	    {
	      if (f.getName().toLowerCase().endsWith(extension))
	      {
	        return true;
	      }
	    }
	    return false;						
	}
	
}

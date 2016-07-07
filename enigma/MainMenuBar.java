package com.grze.enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainMenuBar extends JMenuBar {
	
	private JMenu menuFile;
	private JMenu menuHelp;
	private JMenuItem exitItem;
	private JMenuItem loadFileItem;
	
	private JMenuItem aboutItem;
	
	public MainMenuBar() {
		
		menuFile = new JMenu("File");
		exitItem = new JMenuItem("Exit");
		loadFileItem = new JMenuItem("Load File");
		menuFile.add(exitItem);
		
		menuHelp = new JMenu("Help");
		aboutItem = new JMenuItem("About");
		menuHelp.add(aboutItem);
		
		add(menuFile);
		add(menuHelp);
	
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
				
			}
			
		});
		
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null,
						"Enigmator v. 0.1.1\n"
						+ "Grzegorz Kossowski - 2016\n"
						+ "This is a toy. Encryption\n"
						+ "is NOT fully secure!"
						, "About", 
						JOptionPane.INFORMATION_MESSAGE);
				
			}			
		});
		
		
		
		
		
		
	}

}

package com.grze.enigma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;

public class MainWinow extends JFrame {

	private final int W_WIDTH = 800;
	private final int W_HEIGHT = 640;
	
	private MainMenuBar menuBar;
	private MainToolBar toolBar;
	private MainPanel mainPanel;
			
	public MainWinow(String label) {
		super(label);		
			
		
		menuBar = new MainMenuBar();		
		setJMenuBar(menuBar);
		menuBar.setMenuListener(new MainMenuListener(){
			@Override
			public void menuEventOcurred(MainEvent mev) {
				
				Engine engine = new Engine();
				engine.handle(mev);
				
			}
		});
			
		toolBar = new MainToolBar();
		mainPanel = new MainPanel();
		
		add(toolBar, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		
		toolBar.setToolBarListener(new MainToolBarListener(){
			@Override
			public void toolBarEventOcurred(MainEvent mev) {
								
				Engine engine = new Engine();
				engine.handle(mev);			

			}
		});
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(W_WIDTH, W_HEIGHT));
		setMinimumSize(new Dimension(W_WIDTH, W_HEIGHT));
		setLocationRelativeTo(null);		
		setVisible(true);
		
	}


	private class Engine {
		
		Engine() {}
		
		void handle(MainEvent mev) {
			switch ((String)mev.getValue()) {
			case "LOADFILE":														
				String pathToLoad = mev.getValue2().toString();					
				String textToLoad = FileOperator.loadFile(pathToLoad);
				System.out.println(textToLoad);
				mainPanel.getEditTextPanel().setText(textToLoad);
				mainPanel.getHelpPanel().getHelpArea().setText("File loaded... Encrypt [CTRL+E] or decrypt [CTRL+D] text.");
				break;
			case "SAVEFILE":
				String textToSave = mainPanel.getDisplayTextPanel().getText();				
				String pathToSave = mev.getValue2().toString();
				FileOperator.saveFile(pathToSave, textToSave);
				mainPanel.getHelpPanel().getHelpArea().setText("File saved...");
				break;
			case "ENCRYPT":
				String text = mainPanel.getEditTextPanel().getText();
				String pass = mainPanel.getPassBar().getPasswordString();
				String encrypt = MD5Digest.encrypt(text, MD5Digest.getMD5(pass));					
				mainPanel.getDisplayTextPanel().setText(encrypt);
				mainPanel.getHelpPanel().getHelpArea().setText("Text encrypted... Save it [CTRL+S] or copy to clipboard [CTRL+C].");
				break;
			case "DECRYPT":
				String text2 = mainPanel.getEditTextPanel().getText();
				String pass2 = mainPanel.getPassBar().getPasswordString();
				String decrypt = MD5Digest.decrypt(text2, MD5Digest.getMD5(pass2));					
				mainPanel.getDisplayTextPanel().setText(decrypt);
				mainPanel.getHelpPanel().getHelpArea().setText("Text decrypted... Save it [CTRL+S] or copy to clipboard [CTRL+C].");
				break;
			case "COPYCLIPBOARD":
				String get = mainPanel.getDisplayTextPanel().getText();
				StringSelection selec= new StringSelection(get);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selec, selec);
				mainPanel.getHelpPanel().getHelpArea().setText("Text copied to clipboard... Paste it somewhere [CTRL+V].");
				break;
			case "SWAPCONTENT":
				String disp = mainPanel.getDisplayTextPanel().getText();
				String edit = mainPanel.getEditTextPanel().getText();
				mainPanel.getEditTextPanel().setText(disp);
				mainPanel.getDisplayTextPanel().setText(edit);
				mainPanel.getHelpPanel().getHelpArea().setText("Text swapped...");
				break;
			case "CLEARCONTENT":
				mainPanel.getDisplayTextPanel().setText("");
				mainPanel.getEditTextPanel().setText("");				
				mainPanel.getHelpPanel().getHelpArea().setText("Cleared...");
				break;
			default:
				break;
			}
		}
		
	}
	
}

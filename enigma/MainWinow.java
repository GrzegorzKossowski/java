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
				
				switch ((String)mev.getValue()) {
				case "LOADFILE":					
					System.out.println(mev.getValue2());
					break;
				case "SAVEFILE":
					System.out.println(mev.getValue2());
					break;
				case "ENCRYPT":
					String text = mainPanel.getEditTextPanel().getText();
					String pass = mainPanel.getPassBar().getPasswordString();
					String encrypt = MD5Digest.encrypt(text, MD5Digest.getMD5(pass));					
					mainPanel.getDisplayTextPanel().setText(encrypt);					
					break;
				case "DECRYPT":
					String text2 = mainPanel.getEditTextPanel().getText();
					String pass2 = mainPanel.getPassBar().getPasswordString();
					String decrypt = MD5Digest.decrypt(text2, MD5Digest.getMD5(pass2));					
					mainPanel.getDisplayTextPanel().setText(decrypt);
					break;
				case "COPYCLIPBOARD":
					String get = mainPanel.getDisplayTextPanel().getText();
					StringSelection selec= new StringSelection(get);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(selec, selec);
					break;
				case "SWAPCONTENT":
					String disp = mainPanel.getDisplayTextPanel().getText();
					String edit = mainPanel.getEditTextPanel().getText();
					mainPanel.getEditTextPanel().setText(disp);
					mainPanel.getDisplayTextPanel().setText(edit);					
					break;
				default:
					break;
				}
				
			}
		});
			
		toolBar = new MainToolBar();
		mainPanel = new MainPanel();
		
		add(toolBar, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		
		toolBar.setToolBarListener(new MainToolBarListener(){
			@Override
			public void toolBarEventOcurred(MainEvent mev) {
								
				switch ((String)mev.getValue()) {
				case "LOADFILE":					
					System.out.println(mev.getValue2());
					break;
				case "SAVEFILE":
					System.out.println(mev.getValue2());
					break;
				case "ENCRYPT":
					String text = mainPanel.getEditTextPanel().getText();
					String pass = mainPanel.getPassBar().getPasswordString();
					String encrypt = MD5Digest.encrypt(text, MD5Digest.getMD5(pass));					
					mainPanel.getDisplayTextPanel().setText(encrypt);					
					break;
				case "DECRYPT":
					String text2 = mainPanel.getEditTextPanel().getText();
					String pass2 = mainPanel.getPassBar().getPasswordString();
					String decrypt = MD5Digest.decrypt(text2, MD5Digest.getMD5(pass2));					
					mainPanel.getDisplayTextPanel().setText(decrypt);
					break;
				case "COPYCLIPBOARD":
					String get = mainPanel.getDisplayTextPanel().getText();
					StringSelection selec= new StringSelection(get);
					Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
					clipboard.setContents(selec, selec);
					break;
				case "SWAPCONTENT":
					String disp = mainPanel.getDisplayTextPanel().getText();
					String edit = mainPanel.getEditTextPanel().getText();
					mainPanel.getEditTextPanel().setText(disp);
					mainPanel.getDisplayTextPanel().setText(edit);					
					break;
				default:
					break;
				}
			}
		});
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(W_WIDTH, W_HEIGHT));
		setMinimumSize(new Dimension(W_WIDTH, W_HEIGHT));
		setLocationRelativeTo(null);		
		setVisible(true);
		
	}


	
}

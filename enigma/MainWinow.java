package com.grze.enigma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

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
			
		toolBar = new MainToolBar();		
		mainPanel = new MainPanel();
		
		add(toolBar, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(W_WIDTH, W_HEIGHT));
		setLocationRelativeTo(null);		
		setVisible(true);
		
	}


	
}

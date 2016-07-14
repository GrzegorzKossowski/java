package com.grze.enigma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayHelpPanel extends JPanel {

	private JTextField helpArea;
	
	public DisplayHelpPanel() {
		setLayout(new BorderLayout());
		JLabel label = new JLabel("Info: ");
		add(label, BorderLayout.WEST);		
		add(helpArea = new JTextField(), BorderLayout.CENTER);		
		helpArea.setEditable(false);
		helpArea.setBackground(new Color(237,237,237));
		helpArea.setMargin(new Insets(0,10,0,10));
		helpArea.setForeground(Color.BLUE);
		helpArea.setText("Program is running... Use white space to write your text");
	}

	public JTextField getHelpArea() {
		return helpArea;
	}
	
}

package com.grze.enigma;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DisplayTextPanel extends JPanel {
	
	private JTextArea textArea;
	
	public DisplayTextPanel() {
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea = new JTextArea()), BorderLayout.CENTER);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBackground(new Color(237,237,237));
			
	}

	public void addText(String string) {
		this.textArea.append(string);
	}
	
	public String getText() {
		return this.textArea.getText();
	}
	
	public void setText(String string) {
		this.textArea.setText(string);
	}
	
}

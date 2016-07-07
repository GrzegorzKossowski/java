package com.grze.enigma;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditTextPanel extends JPanel {
	
	private JTextArea textArea;
	
	public EditTextPanel() {
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea = new JTextArea()), BorderLayout.CENTER);
		textArea.setLineWrap(true);
		
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

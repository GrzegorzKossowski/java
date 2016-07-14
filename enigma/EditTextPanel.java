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
		
		
		//temp
		textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Donec eu mi euismod, faucibus dui at, cursus elit. Vestibulum "
				+ "ante ipsum primis in faucibus orci luctus et ultrices posuere "
				+ "cubilia Curae; Morbi suscipit erat ut bibendum condimentum. In "
				+ "consectetur sed sem sit amet egestas. Suspendisse tempor malesuada"
				+ " erat vitae pellentesque. Mauris ac turpis placerat, aliquet magna "
				+ "eget, commodo dolor. Donec aliquam, nulla id accumsan imperdiet, "
				+ "ante ex rhoncus nibh, et posuere turpis est eget dolor.");
		
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

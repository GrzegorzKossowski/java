package com.grze.enigma;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswdBarPanel extends JPanel {

	private JPasswordField passwordField;
	private String passString;
	
	public String getPasswordString() {
		char[] pass = passwordField.getPassword();
		String passString = new String(pass);
		return passString;
	}

	public PasswdBarPanel() {
			
		passwordField = new JPasswordField(20);
		add(passwordField);

	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
}

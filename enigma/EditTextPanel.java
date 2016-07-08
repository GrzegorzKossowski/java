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
/*		textArea.setText("Lorem Ipsum jest tekstem stosowanym "
				+ "jako przykładowy wypełniacz w przemyśle "
				+ "poligraficznym. Został po raz pierwszy użyty w XV w."
				+ " przez nieznanego drukarza do wypełnienia tekstem "
				+ "próbnej książki. Pięć wieków później zaczął być "
				+ "używany przemyśle elektronicznym, pozostając "
				+ "praktycznie niezmienionym. Spopularyzował się w "
				+ "latach 60. XX w. wraz z publikacją arkuszy Letrasetu, "
				+ "zawierających fragmenty Lorem Ipsum, a ostatnio "
				+ "z zawierającym różne wersje Lorem Ipsum "
				+ "oprogramowaniem przeznaczonym do realizacji druków "
				+ "na komputerach osobistych, jak Aldus PageMaker");
*/		
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

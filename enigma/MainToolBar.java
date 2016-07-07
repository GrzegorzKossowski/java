package com.grze.enigma;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainToolBar extends JPanel {

//	private JToolBar toolBar;
	
	public MainToolBar() {
		super(new BorderLayout());		
		JToolBar toolBar = new JToolBar();
		add(toolBar);
		
		JButton decrypt = makeButton("decrypt", "Decrypt", "");
		toolBar.add(decrypt);
		JButton encrypt = makeButton("encrypt", "Encrypt", "");
		toolBar.add(encrypt);
		JButton swap = makeButton("arrows", "Swap text", "");
		toolBar.add(swap);
		
	}

	protected JButton makeButton(String imageName, String toolTipText, String altText) {
		// Look for the image.
		String imgLocation = "/com/grze/enigma/resources/" + imageName + ".png";
		URL imageURL = MainToolBar.class.getResource(imgLocation);
//		ImageIcon icon = new ImageIcon(MainToolBar.class.getResource("com/grze/resources/padlock-closed.png"));

		// Create and initialize the button.
		JButton button = new JButton();
//		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);		

		if (imageURL != null) { // image found
			button.setIcon(new ImageIcon(imageURL, altText));
		} else { // no image found
			button.setText(altText);
			System.err.println("Resource not found: " + imgLocation);
		}
		button.setText(altText);

		return button;
	}
	
	

}

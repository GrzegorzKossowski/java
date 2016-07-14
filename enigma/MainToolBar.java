package com.grze.enigma;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

public class MainToolBar extends JPanel {

	private JToolBar toolBar;
	private JButton openFile;
	private JButton saveFile;
	private JButton decrypt;
	private JButton encrypt;
	private JButton swap;
	private JButton clipboard;
	private JButton clearText;
	
	//listener
	private MainToolBarListener toolBarListener;
	
	private JFileChooser fileChooser;
	
	public MainToolBar() {
		super(new BorderLayout());		
		toolBar = new JToolBar();
		add(toolBar);
		
		fileChooser = new JFileChooser();
		setFileChooser();
		
		openFile = makeButton("open", "Open", "");
		toolBar.add(openFile);
		saveFile = makeButton("save", "Save", "");
		toolBar.add(saveFile);		
		toolBar.addSeparator();
		decrypt = makeButton("decrypt", "Decrypt", "");
		toolBar.add(decrypt);
		encrypt = makeButton("encrypt", "Encrypt", "");
		toolBar.add(encrypt);
		swap = makeButton("arrows", "Swap content", "");
		toolBar.add(swap);
		toolBar.addSeparator();
		clipboard = makeButton("clipboard", "Copy result to clipboard", "");
		toolBar.add(clipboard);
		toolBar.addSeparator();
		clearText = makeButton("clear", "Clear ", "");
		toolBar.add(clearText);
		
		//listeners
		
		openFile.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				if(fileChooser.showOpenDialog(MainToolBar.this) == JFileChooser.APPROVE_OPTION) {
					MainEvent mev = new MainEvent(this, "LOADFILE", fileChooser.getSelectedFile());
					if (toolBarListener != null) {
						toolBarListener.toolBarEventOcurred(mev);
					}	
				}				
			}			
		});
		
		saveFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
							
				if(fileChooser.showSaveDialog(MainToolBar.this) == JFileChooser.APPROVE_OPTION) {
					MainEvent mev = new MainEvent(this, "SAVEFILE", fileChooser.getSelectedFile());
					if (toolBarListener != null) {
						toolBarListener.toolBarEventOcurred(mev);
					}	
				}
			}
		});
		
		decrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEvent mev = new MainEvent(this, "ENCRYPT");
				if (toolBarListener != null) {
					toolBarListener.toolBarEventOcurred(mev);
				}
			}
		});
		
		encrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEvent mev = new MainEvent(this, "DECRYPT");
				if (toolBarListener != null) {
					toolBarListener.toolBarEventOcurred(mev);
				}
			}
		});
		
		swap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEvent mev = new MainEvent(this, "SWAPCONTENT");
				if(toolBarListener!=null) {
					toolBarListener.toolBarEventOcurred(mev);
				}
			}
		});
		
		clipboard.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEvent mev = new MainEvent(this, "COPYCLIPBOARD");
				if(toolBarListener!=null) {
					toolBarListener.toolBarEventOcurred(mev);
				}				
			}
		});
		
		clearText.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEvent mev = new MainEvent(this, "CLEARCONTENT");
				if(toolBarListener!=null) {
					toolBarListener.toolBarEventOcurred(mev);
				}				
			}
		});
		
	}	//end constructor

	protected JButton makeButton(String imageName, String toolTipText, String altText) {
		// Look for the image.
		String imgLocation = "/com/grze/enigma/resources/" + imageName + ".png";
		URL imageURL = MainToolBar.class.getResource(imgLocation);

		// Create and initialize the button.
		JButton button = new JButton();
		// button.setActionCommand(actionCommand);
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
	
	public void setToolBarListener(MainToolBarListener toolBarListener) {
		this.toolBarListener = toolBarListener;
	}
	
private void setFileChooser() {
		
		fileChooser.setAcceptAllFileFilterUsed(false);				
		fileChooser.setFileFilter(new FileFilter() {
			
			String[] okFileExtensions = new String[] {"txt"};
//			String[] okFileExtensions = new String[] {"txt", "dat"};
			
			@Override
			public String getDescription() {

				return "Text files (*.txt)";
//				return "Text files (*.txt, *.dat)";
			}
			
			@Override
			public boolean accept(File f) {

				if (f.isDirectory()) {
		            return true;
		        }
				for (String extension : okFileExtensions)
			    {
			      if (f.getName().toLowerCase().endsWith(extension))
			      {
			        return true;
			      }
			    }
			    return false;						
			}
		});
	}
	
}

package com.grze.enigma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;

public class MainMenuBar extends JMenuBar {

	private JMenu menuFile;
	private JMenu menuTools;
	private JMenu menuHelp;

	private JMenuItem itemSaveFile;
	private JMenuItem itemOpenFile;
	private JMenuItem itemQuit;

	private JMenuItem itemEncrypt;
	private JMenuItem itemDecrypt;
	private JMenuItem itemCopyClipboard;
	private JMenuItem itemPasteClipboard;
	private JMenuItem itemSwapContent;

	private JMenuItem aboutItem;

	// listener
	private MainMenuListener menuListener;

	private JFileChooser fileChooser;
	
	public MainMenuBar() {

		fileChooser = new JFileChooser();
		
		menuFile = new JMenu("File");
		itemOpenFile = new JMenuItem("Open File");
		itemSaveFile = new JMenuItem("Save file");
		itemQuit = new JMenuItem("Quit");

		menuFile.setMnemonic(KeyEvent.VK_F);
		itemOpenFile.setMnemonic(KeyEvent.VK_O);
		itemOpenFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		itemSaveFile.setMnemonic(KeyEvent.VK_S);
		itemSaveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		itemQuit.setMnemonic(KeyEvent.VK_Q);
		itemQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

		itemOpenFile.setEnabled(false);
		itemSaveFile.setEnabled(false);
		
		menuFile.add(itemOpenFile);
		menuFile.add(itemSaveFile);
		menuFile.addSeparator();
		menuFile.add(itemQuit);

		menuTools = new JMenu("Tools");
		itemEncrypt = new JMenuItem("Encrypt");
		itemDecrypt = new JMenuItem("Decrypt");
		itemCopyClipboard = new JMenuItem("Copy");
		itemPasteClipboard = new JMenuItem("Paste");
		itemSwapContent = new JMenuItem("Swap");

		menuTools.setMnemonic(KeyEvent.VK_T);
		itemEncrypt.setMnemonic(KeyEvent.VK_E);
		itemDecrypt.setMnemonic(KeyEvent.VK_D);
		itemCopyClipboard.setMnemonic(KeyEvent.VK_C);
		itemEncrypt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		itemDecrypt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		itemCopyClipboard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		itemPasteClipboard.setEnabled(false);
		itemPasteClipboard.setMnemonic(KeyEvent.VK_V);
		itemPasteClipboard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

		menuTools.add(itemEncrypt);
		menuTools.add(itemDecrypt);
		menuTools.addSeparator();
		menuTools.add(itemCopyClipboard);
		menuTools.add(itemPasteClipboard);
		menuTools.add(itemSwapContent);

		menuHelp = new JMenu("Help");
		aboutItem = new JMenuItem("About");
		menuHelp.add(aboutItem);

		menuHelp.setMnemonic(KeyEvent.VK_H);

		add(menuFile);
		add(menuTools);
		add(menuHelp);

		// ------------- File menu listeners

		itemOpenFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileChooser.setAcceptAllFileFilterUsed(false);				
				fileChooser.setFileFilter(new FileFilter() {
					
					String[] okFileExtensions = new String[] {"txt", "dat"};
					
					@Override
					public String getDescription() {
						// TODO Auto-generated method stub
						return "Text files (*.txt, *.dat)";
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
				
				if(fileChooser.showOpenDialog(MainMenuBar.this) == JFileChooser.APPROVE_OPTION) {
					MainEvent mev = new MainEvent(this, "LOADFILE", fileChooser.getSelectedFile());
					if (menuListener != null) {
						menuListener.menuEventOcurred(mev);
					}	
				}
			}
		});

		itemSaveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(fileChooser.showSaveDialog(MainMenuBar.this) == JFileChooser.APPROVE_OPTION) {
					MainEvent mev = new MainEvent(this, "SAVEFILE", fileChooser.getSelectedFile());
					if (menuListener != null) {
						menuListener.menuEventOcurred(mev);
					}	
				}				
			}
		});

		itemQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int quit = JOptionPane.showConfirmDialog(MainMenuBar.this, 
						"Exit?", "Confirm", 
						JOptionPane.OK_CANCEL_OPTION);
				if(quit == JOptionPane.OK_OPTION) {
					System.exit(0);
				}				
			}
		});

		// ------------- Tools menu listeners

		itemEncrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEvent mev = new MainEvent(this, "ENCRYPT");
				if (menuListener != null) {
					menuListener.menuEventOcurred(mev);
				}
			}
		});

		itemDecrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEvent mev = new MainEvent(this, "DECRYPT");
				if (menuListener != null) {
					menuListener.menuEventOcurred(mev);
				}
			}
		});

		itemCopyClipboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEvent mev = new MainEvent(this, "COPYCLIPBOARD");
				if (menuListener != null) {
					menuListener.menuEventOcurred(mev);
				}
			}
		});

		itemSwapContent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainEvent mev = new MainEvent(this, "SWAPCONTENT");
				if (menuListener != null) {
					menuListener.menuEventOcurred(mev);
				}
			}
		});

		// ------------- Help menu listeners

		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane
						.showMessageDialog(
								null, "Enigmator v. 0.1.1\n" + "Grzegorz Kossowski - 2016\n"
										+ "This is a toy. Encryption\n" + "is NOT fully secure!",
								"About", JOptionPane.INFORMATION_MESSAGE);

			}
		});
	}

	public void setMenuListener(MainMenuListener menuListener) {
		this.menuListener = menuListener;
	}

}

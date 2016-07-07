package com.grze.enigma;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class MainWinow extends JFrame {

	private final int W_WIDTH = 800;
	private final int W_HEIGHT = 640;
	
	private MainMenuBar menuBar;
	private PasswdBarPanel passBar;
	private EditTextPanel editTextPanel;
	private DisplayTextPanel displayTextPanel;
	private JSplitPane splitPane;
	private JButton encryptBtn;
	private JButton decryptBtn;
			
	public MainWinow(String label) {
		super(label);		
			
		
		menuBar = new MainMenuBar();		
		setJMenuBar(menuBar);
		
		encryptBtn = new JButton("Encrypt");
		encryptBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String text = editTextPanel.getText();
				String pass = passBar.getPasswordString();
				String encrypt = MD5Digest.encrypt(text, MD5Digest.getMD5(pass));
				
				displayTextPanel.setText(encrypt);
				
			}
			
		});
		decryptBtn = new JButton("Decrypt");
		decryptBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String text = editTextPanel.getText();
				String pass = passBar.getPasswordString();
				String decrypt = MD5Digest.decrypt(text, MD5Digest.getMD5(pass));
				
				displayTextPanel.setText(decrypt);
				
			}
			
		});
				
		drawGridLayout();		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(W_WIDTH, W_HEIGHT));
		setLocationRelativeTo(null);		
		setVisible(true);
		
	}

	private void drawGridLayout() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 5, 0, 5);
		add(new JLabel("Password: "), gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.weightx = 0.5;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(passBar = new PasswdBarPanel(), gc);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				editTextPanel = new EditTextPanel(),
				displayTextPanel = new DisplayTextPanel());
		splitPane.setResizeWeight(0.5);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 2;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_END;
		add(splitPane, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.1;
		gc.gridwidth = 1;
		gc.insets = new Insets(5,5,5,5);
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.CENTER;
		add(encryptBtn, gc);
				
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.1;
		gc.gridwidth = 1;
		gc.insets = new Insets(5,5,5,5);
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.CENTER;
		add(decryptBtn, gc);

	}
	
}

package com.grze.enigma;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MainPanel extends JPanel {
		
	private PasswdBarPanel passBar;
	private EditTextPanel editTextPanel;
	private DisplayTextPanel displayTextPanel;
	private JSplitPane splitPane;
	private DisplayHelpPanel helpPanel;
	
	
	public MainPanel() {
		
		//szyfrowanie
		
				
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		helpPanel = new DisplayHelpPanel();
		
		drawGridBagLayout(gc);
		
	}
	
	public DisplayHelpPanel getHelpPanel() {
		return helpPanel;
	}

	public DisplayTextPanel getDisplayTextPanel() {
		return displayTextPanel;
	}
	
	public EditTextPanel getEditTextPanel() {
		return editTextPanel;
	}
	
	public PasswdBarPanel getPassBar() {
		return passBar;
	}

	private void drawGridBagLayout(GridBagConstraints gc) {
		//--------------first row		
		gc.gridy = 0;

		gc.gridx = 0;		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 5, 0, 5);
		add(new JLabel("Password: "), gc);
		
		gc.gridx = 1;
		gc.weightx = 0.5;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(passBar = new PasswdBarPanel(), gc);

		//--------------next row
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				editTextPanel = new EditTextPanel(),
				displayTextPanel = new DisplayTextPanel());
		splitPane.setResizeWeight(0.5);
		
		gc.gridy++;
		gc.gridx = 0;
		
		gc.weightx = 1;
		gc.weighty = 2;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.LINE_END;
		add(splitPane, gc);

		gc.gridy++;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridwidth = 2;
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets = new Insets(5, 5, 5, 5);
		add(helpPanel, gc);
				
	}
	
}

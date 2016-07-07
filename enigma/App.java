package com.grze.enigma;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainWinow("Enigmator");					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

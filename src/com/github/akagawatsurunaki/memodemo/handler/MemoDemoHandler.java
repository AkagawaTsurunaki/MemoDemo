package com.github.akagawatsurunaki.memodemo.handler;

import javax.swing.JOptionPane;

import com.github.akagawatsurunaki.memodemo.exceptions.MemoDemoException;

public class MemoDemoHandler {

	public static void handle(MemoDemoException e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), e.getTitle(),JOptionPane.ERROR_MESSAGE);
		System.exit(-1);
	}
	
}

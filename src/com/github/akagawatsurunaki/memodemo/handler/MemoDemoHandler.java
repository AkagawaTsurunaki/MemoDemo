package com.github.akagawatsurunaki.memodemo.handler;

import javax.swing.JOptionPane;

import com.github.akagawatsurunaki.memodemo.exceptions.MemoDemoException;

public class MemoDemoHandler {

	public static void handle(MemoDemoException e) {
		JOptionPane.showInternalConfirmDialog(null, e.getMessage(), e.getTitle(), JOptionPane.YES_OPTION);
		System.exit(-1);
	}
}

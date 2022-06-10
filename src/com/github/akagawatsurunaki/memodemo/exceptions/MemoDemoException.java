package com.github.akagawatsurunaki.memodemo.exceptions;

public class MemoDemoException extends Exception {

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	private static final long serialVersionUID = 1L;
	
	String title;
	String message;
	
	
	public MemoDemoException(String title, String message) {
		this.title = title;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "MemoDemo“Ï≥££∫" + title + ": " + message;
	}

}

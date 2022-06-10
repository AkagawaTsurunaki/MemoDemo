package com.github.akagawatsurunaki.memodemo.controller;

import com.github.akagawatsurunaki.memodemo.dao.WordDao;
import com.github.akagawatsurunaki.memodemo.dao.WordDaoImpl;
import com.github.akagawatsurunaki.memodemo.gui.FindWordFrame;
import com.github.akagawatsurunaki.memodemo.gui.MainFrame;
import com.github.akagawatsurunaki.memodemo.gui.NewWordFrame;
import com.github.akagawatsurunaki.memodemo.model.Word;

public abstract class Controller {
	
	protected static WordDao wordDao = WordDaoImpl.getInstance();
	protected static Word currentWord; 
	protected MainFrame mainFrame;
	protected NewWordFrame newWordFrame;
	protected FindWordFrame findWordFrame;
	
	public abstract void invoke();
	
	public abstract void show();
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public NewWordFrame getNewWordFrame() {
		return newWordFrame;
	}
	
	public void setCurrentWordRandomly() {
		currentWord = wordDao.getRandomWord();
		DemoController.getInstance().updateCurrentWordTextPane();
	}
	
	public void setCurrentWordRandomly(Word w) {
		currentWord = wordDao.getRandomWord(w);
		DemoController.getInstance().updateCurrentWordTextPane();
	}
	
	public void setCurrentWord(Word w) {
		currentWord = w;
		DemoController.getInstance().updateCurrentWordTextPane();
	}
	

	
	
}

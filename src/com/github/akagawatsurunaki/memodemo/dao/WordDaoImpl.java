package com.github.akagawatsurunaki.memodemo.dao;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import com.github.akagawatsurunaki.memodemo.utils.FileUtil;
import com.github.akagawatsurunaki.memodemo.utils.GsonUtil;
import com.google.gson.reflect.TypeToken;
import com.github.akagawatsurunaki.memodemo.exceptions.MemoDemoException;
import com.github.akagawatsurunaki.memodemo.handler.MemoDemoHandler;
import com.github.akagawatsurunaki.memodemo.model.Table;
import com.github.akagawatsurunaki.memodemo.model.Word;
import com.github.akagawatsurunaki.memodemo.model.constants.Constants;

public class WordDaoImpl implements WordDao {

	public Table<Word> getWordsTable() {
		return wordsTable;
	}

	Table<Word> wordsTable = new Table<Word>();

	private static WordDao wordDao = new WordDaoImpl();

	public static WordDao getInstance() {
		if(wordDao == null) {
			wordDao = new WordDaoImpl();
		}
		return wordDao;
	}
	
	static
	{
		WordDaoImpl.getInstance().loadSource();	
	}
	

	@Override
	public boolean loadSource() {

		try {
			String json = FileUtil.readFile(Constants.WORDS_SAVE_PATH);
			wordsTable = GsonUtil.glbGson.fromJson(json, new TypeToken<Table<Word>>() {
			}.getType());

		} catch (IOException e) {
			MemoDemoHandler.handle(new MemoDemoException("IO异常", "MemoDemo不能读取文件。"));
		}
		return false;

	}

	@Override
	public boolean saveSource() {

		try {
			String json = GsonUtil.glbGson.toJson(wordsTable, new TypeToken<Table<Word>>() {
			}.getType());
			FileUtil.writeFile(Constants.WORDS_SAVE_PATH, json);
		} catch (IOException e) {
			MemoDemoHandler.handle(new MemoDemoException("IO异常", "MemoDemo不能读取文件。"));
		}
		return false;

	}
	@Override
	public void addWord(String word, String noun, String pron, String adj, String adv, String verb, String num,
			String art, String prep, String conj, String interj) {
		Word w = new Word(word, noun, pron, adj, adv, verb, num, art, prep, conj, interj);
		w.setId(Constants.DEFAULT_ID);
		wordsTable.add(w);
		saveSource();
	}
	@Override
	public void addWord(int id, String word, String noun, String pron, String adj, String adv, String verb, String num,
			String art, String prep, String conj, String interj) {
		Word w = new Word(word, noun, pron, adj, adv, verb, num, art, prep, conj, interj);
		w.setId(id);
		wordsTable.add(w);
		saveSource();
	}
	
	@Override
	public boolean removeWord(int wordId) {
		boolean flag = wordsTable.removeDataById(wordId);
		saveSource();
		return flag;
	}
	
	@Override
	public void addAnswerCount(int wordId, boolean b) {
		Word w = wordsTable.findDataById(wordId);
		w.setAnswerCount(b);
		saveSource();
	}
	@Override
	public List<Word> getWordsList(){
		return wordsTable.getDataList();
	}
	@Override
	public Word getByIndex(int index) {
		return wordsTable.getDataList().get(index);
	}
	@Override 
	public Word getRandomWord() {
		Random r = new Random();
		int index = r.nextInt(wordDao.getWordsList().size());
		return getByIndex(index);		
	}
	@Override
	public Word getRandomWord(Word w) {
		if(w == null) {
			return getRandomWord();
		}
		Random r = new Random();
		int index = r.nextInt(wordDao.getWordsList().size());
		int currentIndex = wordsTable.getDataList().indexOf(w);
		while(currentIndex == index) {
			index = r.nextInt(wordDao.getWordsList().size());
		}
		return getByIndex(index);
		
	}
	@Override
	public boolean isCorrectAnswer(String answer, Word crtWord) {
		if(answer == null || answer.isEmpty()) {
			return false;
		}
		if(answer.equals(crtWord.getWord())) {
			return true;
		}
		return false;
	}
	@Override
	public List<Word> findWords(String wordStr) {
		
		List<Word> found = new ArrayList<Word>();
		
		for(Word w : wordsTable.getDataList()) {
			if(w.getWord().equals(wordStr)) {
				found.add(w);
			}
		}
		
		return found;
	}


}

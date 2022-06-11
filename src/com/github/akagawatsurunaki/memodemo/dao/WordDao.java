package com.github.akagawatsurunaki.memodemo.dao;

import java.util.List;

import com.github.akagawatsurunaki.memodemo.model.Word;

public interface WordDao {
	
	// Read words table from file.
	boolean loadSource();

	// Save words table to file.
	boolean saveSource();

	// Add a word into the current table.
	void addWord(String word, String noun, String pron, String adj, String adv, String verb, String num, String art,
			String prep, String conj, String interj);
	
	void addWord(int id, String word, String noun, String pron, String adj, String adv, String verb, String num,
			String art, String prep, String conj, String interj);
	
	// Remove a word by its ID.
	boolean removeWord(int wordId);
	
	// Find a word by its word string.
	List<Word> findWords(String wordStr);
	
	// Get words list from memory
	List<Word> getWordsList();

	// Get a word by its index (not its ID)
	Word getByIndex(int index);

	// Get a random word from current words list
	Word getRandomWord();
	
	/**
	 * Get a Random word
	 * @param w a word 
	 * @return a complete new word if w is null, or a new word excludes w.
	 */
	Word getRandomWord(Word w);

	// Is user hava a correct answer?
	boolean isCorrectAnswer(String answer, Word crtWord);

	// After check if the word .
	void addAnswerCount(int wordId, boolean b);

	Word findWordById(int id);
}

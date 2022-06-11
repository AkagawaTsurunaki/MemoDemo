package com.github.akagawatsurunaki.memodemo.controller;

import javax.swing.JOptionPane;
import com.github.akagawatsurunaki.memodemo.gui.NewWordFrame;
import com.github.akagawatsurunaki.memodemo.model.constants.Constants;

public class NewWordController extends Controller {

	// #region Singleton

	private static NewWordController instance = new NewWordController();

	public static NewWordController getInstance() {
		if (instance == null) {
			instance = new NewWordController();
		}
		return instance;
	}

	private NewWordController() {
	}

	// #endregion

	private boolean isEditing = false;

	public void show() {
		NewWordController.getInstance().newWordFrame = new NewWordFrame();
		NewWordController.getInstance().newWordFrame.setVisible(true);
	}

	public void rqsNewWord() {

		if (isEditing) {
			addWord(currentWord.getId());
		} else {
			addWord(Constants.DEFAULT_ID);
		}
		clear();
		isEditing = false;

	}

	public void rqsEdit() {
		isEditing = true;
		show();
		updateWithWord();
	}

	private void addWord(int id) {

		String word = newWordFrame.getTxtFldWord().getText();
		String noun = newWordFrame.getTxtFldNoun().getText();
		String pron = newWordFrame.getTxtFldPron().getText();
		String adj = newWordFrame.getTxtFldAdj().getText();
		String adv = newWordFrame.getTxtFldAdv().getText();
		String verb = newWordFrame.getTxtFldVerb().getText();
		String num = newWordFrame.getTxtFldNum().getText();
		String art = newWordFrame.getTxtFldArt().getText();
		String prep = newWordFrame.getTxtFldPrep().getText();
		String conj = newWordFrame.getTxtFldConj().getText();
		String interj = newWordFrame.getTxtFldInterj().getText();

		if (word.isEmpty()) {
			JOptionPane.showMessageDialog(newWordFrame, "你不能新建一个Word为空的单词.", "新增单词失败", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (noun.isEmpty() && pron.isEmpty() && adj.isEmpty() && adv.isEmpty() && verb.isEmpty() && num.isEmpty()
				&& art.isEmpty() && prep.isEmpty() && conj.isEmpty() && interj.isEmpty()) {
			JOptionPane.showMessageDialog(newWordFrame, "你不能新建一个没有释义的单词。", "新增单词失败", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (id == Constants.DEFAULT_ID)
			wordDao.addWord(word, noun, pron, adj, adv, verb, num, art, prep, conj, interj);
		else
			wordDao.addWord(id, word, noun, pron, adj, adv, verb, num, art, prep, conj, interj);
		DemoController.getInstance().updateCurrentWordTextPane();
		JOptionPane.showMessageDialog(newWordFrame, "单词" + newWordFrame.getTxtFldWord().getText() + "被成功添加至已有词书。",
				"新增单词成功", JOptionPane.INFORMATION_MESSAGE);
		
		DemoController.getInstance().updateCurrentWordTextPane();
	}

	private void clear() {
		newWordFrame.getTxtFldWord().setText("");
		newWordFrame.getTxtFldNoun().setText("");
		newWordFrame.getTxtFldPron().setText("");
		newWordFrame.getTxtFldAdj().setText("");
		newWordFrame.getTxtFldAdv().setText("");
		newWordFrame.getTxtFldVerb().setText("");
		newWordFrame.getTxtFldNum().setText("");
		newWordFrame.getTxtFldArt().setText("");
		newWordFrame.getTxtFldPrep().setText("");
		newWordFrame.getTxtFldConj().setText("");
		newWordFrame.getTxtFldInterj().setText("");
	}

	public void updateWithWord() {

		if (currentWord == null) {
			JOptionPane.showMessageDialog(newWordFrame, "当前没有可以修改的单词。", "不能编辑单词", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		newWordFrame.getTxtFldWord().setText(currentWord.getWord());

		for (int i = 0; i < currentWord.getMeaningList().size(); i++) {

			switch (currentWord.getMeaningList().get(i).getPartOfSpeech()) {
			case NOUN: {
				newWordFrame.getTxtFldNoun().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			case PRONOUN: {
				newWordFrame.getTxtFldPron().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			case ADJECTIVE: {
				newWordFrame.getTxtFldAdj().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			case ADVERB: {
				newWordFrame.getTxtFldAdv().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			case VERB: {
				newWordFrame.getTxtFldVerb().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			case NUMERAL: {
				newWordFrame.getTxtFldNum().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			case ARTICLE: {
				newWordFrame.getTxtFldArt().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			case PREPOSITION: {
				newWordFrame.getTxtFldPrep().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			case CONJUNCTION: {
				newWordFrame.getTxtFldConj().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			case INTERJECTION: {
				newWordFrame.getTxtFldInterj().setText(currentWord.getMeaningList().get(i).getContent());
				break;
			}
			}
		}

	}

	@Override
	public void invoke() {
		show();
	}
}

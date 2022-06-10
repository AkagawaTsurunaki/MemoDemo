package com.github.akagawatsurunaki.memodemo.model;

import java.util.ArrayList;
import java.util.List;

import com.github.akagawatsurunaki.memodemo.model.enumeration.PartOfSpeech;

public class Word extends MemoDemoObject {

	List<Meaning> meaningList = new ArrayList<Meaning>();

	public class Meaning {
		PartOfSpeech partOfSpeech;
		String content;

		public Meaning(PartOfSpeech pos, String content) {
			this.partOfSpeech = pos;
			this.content = content;
		}
		
		public PartOfSpeech getPartOfSpeech() {
			return partOfSpeech;
		}
		
		public String getContent() {
			return content;
		}
		
		@Override
		public String toString() {
			return partOfSpeech.toString() + " " + content + "\n"; 
		}
	}

	String word;
	int wrongAnswerCount;
	int correctAnswerCount;

	public String getWord() {
		return word;
	}

	public List<Meaning> getMeaningList() {
		return meaningList;
	}

	public int getWrongAnswerCount() {
		return wrongAnswerCount;
	}

	public int getCorrectAnswerCount() {
		return correctAnswerCount;
	}

	public Word(String word, String noun, String pron, String adj, String adv, String verb, String num, String art,
			String prep, String conj, String interj) {
		
		if(!(word.isEmpty() || word == null)) {
			this.word = word;
		}
		if(!(noun.isEmpty() || noun == null)) {
			meaningList.add(new Meaning(PartOfSpeech.NOUN, noun));
		}
		if(!(pron.isEmpty() || pron == null)) {
			meaningList.add(new Meaning(PartOfSpeech.PRONOUN, pron));
		}
		if(!(adj.isEmpty() || adj == null)) {
			meaningList.add(new Meaning(PartOfSpeech.ADJECTIVE, adj));
		}
		if(!(adv.isEmpty() || adv == null)) {
			meaningList.add(new Meaning(PartOfSpeech.ADVERB, adv));
		}
		if(!(verb.isEmpty() || verb == null)) {
			meaningList.add(new Meaning(PartOfSpeech.VERB, verb));
		}
		if(!(num.isEmpty() || num == null)) {
			meaningList.add(new Meaning(PartOfSpeech.NUMERAL, num));
		}
		if(!(art.isEmpty() || art == null)) {
			meaningList.add(new Meaning(PartOfSpeech.ARTICLE, art));
		}
		if(!(prep.isEmpty() || prep == null)) {
			meaningList.add(new Meaning(PartOfSpeech.PREPOSITION, prep));
		}
		if(!(conj.isEmpty() || conj == null)) {
			meaningList.add(new Meaning(PartOfSpeech.CONJUNCTION, conj));
		}
		if(!(interj.isEmpty() || interj == null)) {
			meaningList.add(new Meaning(PartOfSpeech.INTERJECTION, interj));
		}
		wrongAnswerCount = 0;
		correctAnswerCount = 0;

	}

	public Word(String word, List<Meaning> mnList, int wCount, int cCount) {
		this.word = word;
		this.meaningList = mnList;
		this.wrongAnswerCount = wCount;
		this.correctAnswerCount = cCount;
	}

	public Word(String word, List<Meaning> mnList) {
		this.word = word;
		this.meaningList = mnList;
		this.wrongAnswerCount = 0;
		this.correctAnswerCount = 0;
	}

	public int getAnswerCount() {
		return wrongAnswerCount + correctAnswerCount;
	}

	public float getCorrectAnswerFillRate() {
		return (float) correctAnswerCount / (float) (getAnswerCount());
	}

	public void setAnswerCount(boolean b) {
		if(b) {
			correctAnswerCount++;
		} else {
			wrongAnswerCount++;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(word).append("\n");
		for(Meaning m : meaningList) {
			sb.append(m.toString());
		}
		return sb.toString();
	}
	
	public String toMeaningString() {
		StringBuilder sb = new StringBuilder();
		for(Meaning m : meaningList) {
			sb.append(m.toString());
		}
		return sb.toString();
	}
	
}

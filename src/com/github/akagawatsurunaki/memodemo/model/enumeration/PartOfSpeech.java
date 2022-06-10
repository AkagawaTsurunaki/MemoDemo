package com.github.akagawatsurunaki.memodemo.model.enumeration;

public enum PartOfSpeech {
	NOUN {
		@Override
		public String toString() {
			return "n.";
		}
	},
	PRONOUN {
		@Override
		public String toString() {
			return "pron.";
		}
	},
	ADJECTIVE {
		@Override
		public String toString() {
			return "adj.";
		}
	},
	ADVERB {
		@Override
		public String toString() {
			return "adv.";
		}
	},
	VERB {
		@Override
		public String toString() {
			return "v.";
		}
	},
	NUMERAL {
		@Override
		public String toString() {
			return "num.";
		}
	},
	ARTICLE {
		@Override
		public String toString() {
			return "art.";
		}
	},
	PREPOSITION {
		@Override
		public String toString() {
			return "prep.";
		}
	},
	CONJUNCTION {
		@Override
		public String toString() {
			return "conj.";
		}
	},
	INTERJECTION {
		@Override
		public String toString() {
			return "interj.";
		}
	}
}

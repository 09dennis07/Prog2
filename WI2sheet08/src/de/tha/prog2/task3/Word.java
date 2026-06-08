package de.tha.prog2.task3;

import java.util.Objects;

public class Word implements Comparable<Word> {
	
	String word;
	
	public Word(String word, Position position) {
		this.word = word.toLowerCase();
		this.position = position;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(position, word);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return position == other.position && Objects.equals(word, other.word);
	}

	public enum Position {
		START,
		MIDDLE,
		END
	}
	
	private Position position;
	
	public String getWord() {
		return this.word;
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public String toString() {
	    return this.word + " (" + this.position + ")"; 
	}

	@Override
	public int compareTo(Word other) {
	    int wordCompare = this.word.compareTo(other.word);
	    
	    if (wordCompare == 0) {
	        return this.position.compareTo(other.position);
	    }
	    return wordCompare;
	}

}

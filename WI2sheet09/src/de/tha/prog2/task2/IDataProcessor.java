package de.tha.prog2.task2;

import java.util.List;

public interface IDataProcessor {	
	/**
	 * The method takes a List of Strings. Each String in the list is a 
	 * word, that may or may not contain the character '_'. This method removes
	 * the underscore from each word and concatenates the words into a single string.
	 * 
	 * @param list A list that contains a number of words
	 * @return String Sentence consisting of the words from list with underscores '_' removed
	 */
	public String mergeWithoutUnderscore(List<String> list);
	
	/**
	 * Takes a list of Strings. Returns a copy of the list with all 
	 * characters converted to uppercase;
	 */
	public List<String> convertUpperCase(List<String> list);
	
	/**
	 * Takes a list of Strings and counts the number of vowels in all 
	 * Strings in the list
	 * @return Number of vowels in all strings
	 */
	public long countVowels(List<String> list);
	
	/**
	 * Counts uneven numbers of Integers in the list
	 */
	public long countUneven(List<Integer> list);
}

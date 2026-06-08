package de.tha.prog2.task1;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class AlternatingWordCapitalizer {

	public static void capitalize(Reader reader, Writer writer) throws IOException {

		int currentChar;
		boolean isCapital = false;
		boolean inWord = false;
		while ((currentChar = reader.read()) != -1) {
			char c = (char) currentChar;
			if (Character.isLetter(c)) {
				if (!inWord) { 
			        isCapital = !isCapital; 
			        inWord = true;          
			    }
				if (isCapital) {
					writer.write(Character.toUpperCase(c));
				} else {
					writer.write(Character.toLowerCase(c));
				}
			} else {
				inWord = false;
				writer.write(c);
			}

		}
		writer.flush();

	}
}

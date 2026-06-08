package de.tha.prog2.task1;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class AlternatingWordCapitalizerFilter extends FilterReader {
	
	boolean inWord = false;
	boolean isCapital = false;

	protected AlternatingWordCapitalizerFilter(Reader in) {
		super(in);
	}

	public int read(char[] cbuf, int off, int len) throws IOException {
		if (len == 0) {
			return 0;
		}
		int charsRead = super.read(cbuf, off, len);
		for (int i = off; i < off + charsRead; i++) {
			char c = cbuf[i];
			if (Character.isLetter(c)) {
				if (!inWord) {
					isCapital = !isCapital;
					inWord = true;
				}
				if (isCapital) {
					cbuf[i] = Character.toUpperCase(c);
				} else {
					cbuf[i] = Character.toLowerCase(c);
				}
			} else {
				inWord = false;
				cbuf[i] = c;
			}
		}
		return charsRead;
	}

}

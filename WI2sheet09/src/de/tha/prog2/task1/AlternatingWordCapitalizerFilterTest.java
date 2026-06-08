package de.tha.prog2.task1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.io.Reader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlternatingWordCapitalizerFilterTest {

	@Test
	void exampleText() throws IOException {
		
	    Reader text = new StringReader("Dies ist ein Text, mit mehreren Wörtern!");
	    Reader filter = new AlternatingWordCapitalizerFilter(text);
	    char[] cbuf = new char[100]; 
	    int charsRead = filter.read(cbuf, 0, cbuf.length);
	    String result = charsRead == -1 ? "" : new String(cbuf, 0, charsRead);
	    assertEquals("DIES ist EIN text, MIT mehreren WÖRTERN!", result);
	}
	
	@Test
	void spacesTest() throws IOException {
	    Reader text = new StringReader("Dies  ist  ein  Text,  mit  mehreren  Wörtern!");
	    Reader filter = new AlternatingWordCapitalizerFilter(text);
	    char[] cbuf = new char[100]; 
	    int charsRead = filter.read(cbuf, 0, cbuf.length);
	    String result = charsRead == -1 ? "" : new String(cbuf, 0, charsRead);
	    assertEquals("DIES  ist  EIN  text,  MIT  mehreren  WÖRTERN!", result);
	}
	
	@Test
	void lineBreakTest() throws IOException {
		    Reader text = new StringReader("Dies  ist  ein  Text,  \nmit  mehreren  Wörtern!");
		    Reader filter = new AlternatingWordCapitalizerFilter(text);
		    char[] cbuf = new char[100]; 
		    int charsRead = filter.read(cbuf, 0, cbuf.length);
		    String result = charsRead == -1 ? "" : new String(cbuf, 0, charsRead);
		    assertEquals("DIES  ist  EIN  text,  \nMIT  mehreren  WÖRTERN!", result);
		}
	
	@Test
	void emptyTest() throws IOException {
	    Reader text = new StringReader("");
	    Reader filter = new AlternatingWordCapitalizerFilter(text);
	    char[] cbuf = new char[100]; 
	    int charsRead = filter.read(cbuf, 0, cbuf.length);
	    String result = charsRead == -1 ? "" : new String(cbuf, 0, charsRead);
	    assertEquals("", result);
	}

}

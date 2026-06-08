package de.tha.prog2.task1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlternatingWordCapitalizerTest {
	
    Writer writer;
	

	@BeforeEach
	void setUp() throws Exception {
		writer = new StringWriter();
	}

	@Test
	void exampleText() throws IOException {
		AlternatingWordCapitalizer.capitalize(new StringReader("Dies ist ein Text, mit mehreren Wörtern!"),writer);
		assertEquals("DIES ist EIN text, MIT mehreren WÖRTERN!", writer.toString());
	}
	
	@Test
	void spacesTest() throws IOException {
		AlternatingWordCapitalizer.capitalize(new StringReader("Dies  ist  ein  Text,  mit  mehreren  Wörtern!"),writer);
		assertEquals("DIES  ist  EIN  text,  MIT  mehreren  WÖRTERN!", writer.toString());
	}
	
	@Test
	void lineBreakTest() throws IOException {
		AlternatingWordCapitalizer.capitalize(new StringReader("Dies ist ein Text, \nmit mehreren Wörtern!"),writer);
		assertEquals("DIES ist EIN text, \nMIT mehreren WÖRTERN!", writer.toString());
	}
	
	@Test
	void emptyTest() throws IOException {
		AlternatingWordCapitalizer.capitalize(new StringReader(""),writer);
		assertEquals("", writer.toString());
	}

}

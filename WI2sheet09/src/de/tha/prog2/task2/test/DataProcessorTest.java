package de.tha.prog2.task2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.tha.prog2.task2.IDataProcessor;

public class DataProcessorTest {

	private IDataProcessor createProcessor() throws Exception {
		Class<?> clazz = Class.forName("de.tha.prog2.task2.DataReader");
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		return (IDataProcessor) constructor.newInstance();
	}

	@Test
	public void testMergeWithoutUnderscore() throws Exception {
		IDataProcessor processor = createProcessor();
		List<String> words = Arrays.asList("Die_s", "ist", "_ein_", "Test");
		assertEquals("Dies ist ein Test", processor.mergeWithoutUnderscore(words));
	}
	
	@Test
	public void testConvertUpperCase() throws Exception {
		IDataProcessor processor = createProcessor();
		List<String> words = Arrays.asList("Dies", "ist", "_ein_", "Test");
		assertEquals(Arrays.asList("DIES", "IST", "_EIN_", "TEST"), processor.convertUpperCase(words));
	}
	
	@Test
	public void testCountVowels() throws Exception {
		IDataProcessor processor = createProcessor();
		List<String> words = Arrays.asList("AEIUO", "aeiou", "Dies", "ist", "_ein_", "Test");
		assertEquals(16, processor.countVowels(words));
	}
	
	@Test
	public void testCountUneven() throws Exception {
		IDataProcessor processor = createProcessor();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		assertEquals(4, processor.countUneven(numbers));
	}
}

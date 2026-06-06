package de.tha.prog2.task2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.tha.prog2.task2.IDataReader;
import de.tha.prog2.task2.ListContainer;

public class DeserializationTest {
	private List<String> testStringList = new ArrayList<>(Arrays.asList("Test", "Test"));
	private List<Integer> testIntList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

	private IDataReader createDataReader() throws Exception {
		Class<?> clazz = Class.forName("de.tha.prog2.task2.DataReader");
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		return (IDataReader) constructor.newInstance();
	}

	@Test
	public void testIDataReader() throws Exception {
		IDataReader dataReader = createDataReader();
		ListContainer listContainer = new ListContainer(testStringList, testIntList);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(1);
		oos.writeObject(listContainer);
		oos.flush();
		bos.flush();
		assertEquals(listContainer, dataReader.getListContainer(new ByteArrayInputStream(bos.toByteArray())));
	}
}

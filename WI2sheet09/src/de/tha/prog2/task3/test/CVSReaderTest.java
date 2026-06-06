package de.tha.prog2.task3.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.tha.prog2.task3.ICSVReader;
import de.tha.prog2.task3.IWeatherEntry;
import de.tha.prog2.task3.IWeatherStation;

public class CVSReaderTest {

	private ICSVReader createCSVReader() throws Exception {
		Class<?> clazz = Class.forName("de.tha.prog2.task3.CSVReader");
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		return (ICSVReader) constructor.newInstance();
	}

	private IWeatherStation createWeatherStation(int i, String state, String city) throws Exception {
		Class<?> clazz = Class.forName("de.tha.prog2.task3.WeatherStation");
		Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, String.class, String.class);
		constructor.setAccessible(true);
		return (IWeatherStation) constructor.newInstance(i, state, city);
	}

	private IWeatherEntry createWeatherEntry(int id, String date, double min, double max, double rain) throws Exception {
		Class<?> clazz = Class.forName("de.tha.prog2.task3.WeatherEntry");
		Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, String.class, double.class, double.class, double.class);
		constructor.setAccessible(true);
		return (IWeatherEntry) constructor.newInstance(id, date, min, max, rain);
	}

	@Test
	public void testStationReader() throws Exception {
		String testData = "StationsID;Ort;Bundesland\n" +
				"00001;Aach;Baden-Württemberg\n" +
				"00003;Aachen;Nordrhein-Westfalen";
		ByteArrayInputStream bis = new ByteArrayInputStream(testData.getBytes(StandardCharsets.UTF_8));
		ICSVReader csvreader = createCSVReader();

		List<IWeatherStation> targetList = new ArrayList<>(Arrays.asList(
				createWeatherStation(1, "Aach", "Baden-Württemberg"),
				createWeatherStation(3, "Aachen", "Nordrhein-Westfalen")
		));

		List<IWeatherStation> createdList = csvreader.readWeatherStations(bis);

		assertTrue(targetList.containsAll(createdList));
		assertTrue(createdList.containsAll(targetList));
	}

	@Test
	public void testWeatherEntryReader() throws Exception {
		String testData = "STATIONS_ID;MESS_DATUM;NIEDERSCHLAG;TAGESMAXTEMPERATUR;TAGESMINTEMPERATUR\n" +
				"231;18790101;5.7;9.4;6.0\n" +
				"431;18790102;0.2;7.8;0.1";
		ByteArrayInputStream bis = new ByteArrayInputStream(testData.getBytes(StandardCharsets.UTF_8));
		ICSVReader csvreader = createCSVReader();

		List<IWeatherEntry> targetList = new ArrayList<>(Arrays.asList(
				createWeatherEntry(231, "18790101", 5.7, 9.4, 6.0),
				createWeatherEntry(431, "18790102", 0.2, 7.8, 0.1)
		));

		List<IWeatherEntry> createdList = csvreader.readWeatherEntries(bis);

		assertTrue(targetList.containsAll(createdList));
		assertTrue(createdList.containsAll(targetList));
	}
}
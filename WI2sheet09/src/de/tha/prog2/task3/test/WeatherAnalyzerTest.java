package de.tha.prog2.task3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.tha.prog2.task3.IWeatherAnalyzer;
import de.tha.prog2.task3.IWeatherStation;


public class WeatherAnalyzerTest {
	private InputStream stationStream;
	private InputStream weatherStream;

	private IWeatherAnalyzer createWeatherAnalyzer() throws Exception {
		Class<?> clazz = Class.forName("de.tha.prog2.blatt8.task3.WeatherAnalyzer");
		Constructor<?> constructor = clazz.getDeclaredConstructor(InputStream.class, InputStream.class);
		constructor.setAccessible(true);
		return (IWeatherAnalyzer) constructor.newInstance(stationStream, weatherStream);
	}

	private IWeatherStation createWeatherStation(int i, String state, String city) throws Exception {
		Class<?> clazz = Class.forName("de.tha.prog2.blatt8.task3.WeatherStation");
		Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, String.class, String.class);
		constructor.setAccessible(true);
		return (IWeatherStation) constructor.newInstance(i, state, city);
	}

	@BeforeEach
	public void setup() {
		String stationdata = "StationsID;Ort;Bundesland\n00001;Aach;Baden-Württemberg\n00003;Aachen;Nordrhein-Westfalen\n00070;Albstadt-Ebingen;Baden-Württemberg";
		stationStream = new ByteArrayInputStream(stationdata.getBytes(StandardCharsets.UTF_8));
		String weatherdata = "STATIONS_ID;MESS_DATUM;NIEDERSCHLAG;TAGESMAXTEMPERATUR;TAGESMINTEMPERATUR\n"
				+ "1;19370101;0.0;2.5;-1.6\n"
				+ "1;19370102;0.0;5.0;-4.0\n"
				+ "1;19370103;0.0;5.0;-0.2\n"
				+ "1;19370104;0.0;3.8;-0.2\n"
				+ "1;19370105;0.0;4.5;-0.7\n"
				+ "1;19370106;8.2;4.5;-0.7\n"
				+ "3;18910101;0.0;0.5;-5.9\n"
				+ "3;18910102;0.0;0.0;-5.8\n"
				+ "3;18910103;2.5;2.1;-6.2\n"
				+ "3;18910104;8.2;3.7;0.6\n"
				+ "3;18910105;1.9;5.0;-4.2\n"
				+ "70;19731228;0.0;0.5;-2.7\n"
				+ "70;19731229;0.0;-1.8;-7.3\n"
				+ "70;19731230;0.0;-5.6;-10.0\n"
				+ "70;19731231;0.0;-2.4;-9.5";
		weatherStream = new ByteArrayInputStream(weatherdata.getBytes(StandardCharsets.UTF_8));
	}

	@Test
	public void testHighestTemperature() throws Exception {
		IWeatherAnalyzer weatherAnalyzer = createWeatherAnalyzer();
		assertEquals(5.0, weatherAnalyzer.getHighestTemperature());
	}

	@Test
	public void testStationsHighestTemperature() throws Exception {
		IWeatherAnalyzer weatherAnalyzer = createWeatherAnalyzer();
		List<IWeatherStation> expectedWeatherStations = Arrays.asList(
				createWeatherStation(1, "Aach", "Baden-Württemberg"),
				createWeatherStation(3, "Aachen", "Nordrhein-Westfalen")
		);

		assertTrue(weatherAnalyzer.getStationsWithHighestTemperature().containsAll(expectedWeatherStations));
		assertTrue(expectedWeatherStations.containsAll(weatherAnalyzer.getStationsWithHighestTemperature()));
	}

	@Test
	public void testStationPerState() throws Exception {
		IWeatherAnalyzer weatherAnalyzer = createWeatherAnalyzer();
		Map<String, Long> expectedStateMap = new LinkedHashMap<>();
		expectedStateMap.put("Nordrhein-Westfalen", 1l);
		expectedStateMap.put("Baden-Württemberg", 2l);

		Map<String, Long> generatedMap = weatherAnalyzer.getStationsPerState();

		assertEquals(2, generatedMap.size());

		java.util.Iterator<Entry<String, Long>> generatedIterator = generatedMap.entrySet().iterator();
		java.util.Iterator<Entry<String, Long>> expectedIterator = expectedStateMap.entrySet().iterator();

		assertEquals(expectedIterator.next(), generatedIterator.next());
		assertEquals(expectedIterator.next(), generatedIterator.next());

	}
}

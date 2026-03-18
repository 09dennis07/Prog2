package de.tha.prog2.task02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataAnalyzerSortTest {

	private static final double DELTA = 1e-9;

	@Test
	void testSortAscending() {
		DataAnalyzer analyzer = new DataAnalyzer();
		double[] values = {4.0, 1.0, 3.0, 2.0};

		analyzer.sort(values, false);

		assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0}, values, DELTA);
	}

	@Test
	void testSortDescending() {
		DataAnalyzer analyzer = new DataAnalyzer();
		double[] values = {4.0, 1.0, 3.0, 2.0};

		analyzer.sort(values, true);

		assertArrayEquals(new double[]{4.0, 3.0, 2.0, 1.0}, values, DELTA);
	}

}
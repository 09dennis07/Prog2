package de.tha.task01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
	
	Calculator scorecal;
	
	@BeforeEach 
	public void setup() {
		scorecal = ScoreCalculator.getCalculator();
	}
	
	@Test
	public void testPercentage() {
		assertEquals(75.0, scorecal.percentage(75, 100));
		assertEquals(33.33, scorecal.percentage(1, 3));
		assertEquals(0.0, scorecal.percentage(0, 50));
	}
	
	@Test
	public void testGrade() {
		assertEquals("sehr gut", scorecal.grade(95.0));
		assertEquals("gut", scorecal.grade(80.0));
		assertEquals("mangelhaft", scorecal.grade(55.0));
	}
	
	@Test
	public void testAnonymousClass() {
		assertTrue(scorecal.getClass().isAnonymousClass());
	}
	
}

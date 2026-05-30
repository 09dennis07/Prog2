package de.tha.prog2.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	Calculator calc;
	
	@BeforeEach
	public void setUp() {
		calc = RoundCalculator.getCalculator();		
	}
	
	@Test
	public void testLog10() {
		assertEquals(3.0, calc.log10(101.));
		assertEquals(3.0, calc.log10(999.));
		assertEquals(0, calc.log10(1.));
	}
	
	@Test
	public void testMultiply() {
		assertEquals(8.0, calc.multiply(2.5, 3));
		assertEquals(1.0, calc.multiply(0.1, 0.1));
	}
	
}

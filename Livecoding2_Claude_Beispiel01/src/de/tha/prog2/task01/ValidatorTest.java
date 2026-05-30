package de.tha.prog2.task01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
	
	Validator txtVal;
	
	@BeforeEach
	public void setup() {
		txtVal = TextValidator.getValidator();
	}
	
	@Test
	public void testIsEMail() {
		assertTrue(txtVal.isEmail("max@tha.de"));
		assertFalse(txtVal.isEmail("keineat-zeichen"));
		assertFalse(txtVal.isEmail("doppelt@@tha.de"));
	}
	
	@Test
	public void  testIsPalindrome() {
		assertTrue(txtVal.isPalindrome("Maoam"));
		assertFalse(txtVal.isPalindrome("Regen"));
		assertTrue(txtVal.isPalindrome("Never odd or even"));
	}
	
	@Test
	public void testAnonymousClass() {
		assertTrue(txtVal.getClass().isAnonymousClass());
	}

}

package de.tha.prog2.task1;

public class RoundCalculator {
	
	
	public static Calculator getCalculator() {
		
		return new Calculator() {
			
			@Override 
			public double log10(double value) {
				return Math.ceil(Math.log10(value));
			}
			
			public double multiply(double a, double b) {
				return Math.ceil(a * b);
			}
		};
				
	}
}

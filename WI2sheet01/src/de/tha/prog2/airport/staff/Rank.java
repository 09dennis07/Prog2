package de.tha.prog2.airport.staff;

public enum Rank {
	COPILOT(5000), 
	FIRST_OFFICER(7000), 
	CAPTAIN(9000);
	
	private final double baseSalary;
	
	private Rank(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
}

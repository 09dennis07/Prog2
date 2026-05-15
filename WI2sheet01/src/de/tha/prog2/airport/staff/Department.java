package de.tha.prog2.airport.staff;

public enum Department {
	TECHNICAL(3500.),
	HANDLING(3000.),
	SECURITY(3200.),
	CHECK_IN(2800.);
	
	private final double baseSalary;
	
	private Department(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}

}

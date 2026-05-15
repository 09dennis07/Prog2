package de.tha.prog2.airport.staff;

public abstract class Employee {
	
	public static void main(String[] args) {
		
//		Employee employee = new Employee("Max", "Mustermann", 3500);
//		
//		System.out.println(employee.toString());
//		
	}
	
	protected int employeeId;
	protected double baseSalary;
	protected String firstName;
	protected String lastName;
	private static int nextEmployeeId = 1;
	
	public Employee(String lastName, String firstName, double baseSalary) {
		this.employeeId = nextEmployeeId++;
		this.lastName = lastName;
		this.firstName = firstName;
		this.baseSalary = baseSalary;
	}
	
	public abstract void promote();
	
	public double calculateSalary() {
		return baseSalary;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String toString() {
		return String.format("Employee{id=%d, lastName=%s, firstName=%s, baseSalary=%.1f}", employeeId, lastName, firstName, baseSalary);
	}

}

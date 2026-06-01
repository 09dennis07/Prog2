package de.tha.prog2.task2;

public class Employee {
	
	private int employeeID;
	private String name;
	private String department;
	private double yearsEmployed;
	
	public Employee(int eimployeeID, String name, String department, double yearsEmployed) {
		super();
		this.employeeID = eimployeeID;
		this.name = name;
		this.department = department;
		this.yearsEmployed = yearsEmployed;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public double getYearsEmployed() {
		return yearsEmployed;
	}
	
	
	

}

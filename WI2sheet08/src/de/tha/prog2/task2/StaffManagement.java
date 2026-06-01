package de.tha.prog2.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StaffManagement {
	
	private Map<Integer, Employee> employees;
	
	public StaffManagement() {
		employees = new HashMap<Integer, Employee>();
	}

	public void addEmployee(Employee e) {
		if (employees.putIfAbsent(e.getEmployeeID(), e) != null) {
			throw new DuplicateEmployeeException();
		}
	}
	
	public List<Employee> getEmployeesSortedByName() {
		List<Employee> sortNameList = new ArrayList<Employee>(employees.values());
		
		sortNameList.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				
				int lastSpace1 = e1.getName().lastIndexOf(" ");
				int lastSpace2 = e2.getName().lastIndexOf(" ");
				
				String vorname1 = (lastSpace1 == -1) ? e1.getName() : e1.getName().substring(0, lastSpace1);
				String nachname1 = (lastSpace1 == -1) ? "" : e1.getName().substring(lastSpace1 + 1);
				
				String vorname2 = (lastSpace2 == -1) ? e2.getName() : e2.getName().substring(0, lastSpace2);
				String nachname2 = (lastSpace2 == -1) ? "" : e2.getName().substring(lastSpace2 + 1);
				
				int resultCompare;
				if ((resultCompare = vorname1.compareTo(vorname2)) != 0) {
					return resultCompare;
				} else {
					return nachname1.compareTo(nachname2);
				}			
			}
		});
		return sortNameList;
	}
	
	public List<Employee> getEmployeesSortedByNameStream() {
	    return employees.values().stream()
	        .sorted(Comparator
	            
	            .comparing((Employee e) -> {
	                int lastSpace = e.getName().lastIndexOf(" ");
	                return (lastSpace == -1) ? e.getName() : e.getName().substring(0, lastSpace);
	            })
	            
	            .thenComparing((Employee e) -> {
	                int lastSpace = e.getName().lastIndexOf(" ");
	                return (lastSpace == -1) ? "" : e.getName().substring(lastSpace + 1);
	            })
	        )
	        .collect(Collectors.toList());
	}
	
	public List<Employee> getEmployeesSortedByYearsEmployed() {
		List<Employee> sortYearsList = new ArrayList<Employee>(employees.values());
		
		sortYearsList.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee e1, Employee e2) {
				
				double years1 = e1.getYearsEmployed();
				double years2 = e2.getYearsEmployed();
				
				int resultCompare = Double.compare(years2, years1);
				
				return resultCompare;
			}						
			});
		return sortYearsList;
	}
	
	public List<Employee> getEmployeesSortedByYearsEmployedStream() {
		return employees.values().stream()
				.sorted(Comparator.comparingDouble(Employee::getYearsEmployed).reversed())
				.collect(Collectors.toList());
	}
	
	public List<Employee> getEmployeesFromDepartment(String department) {
		List<Employee> departmentList = new ArrayList<Employee>();
		for (Employee e : employees.values()) {
			String dep = e.getDepartment();

			if (dep.equals(department)) {
				departmentList.add(e);
			}
		}
		return departmentList;
	}
	
	public List<Employee> getEmployeesFromDepartmentStream(String department) {
		return employees.values().stream()
				.filter(e -> e.getDepartment().equals(department))
				.collect(Collectors.toList());
	}
	
	public Map<String, Employee> getLongestEmployedEmployeePerDepartement() {
		List<Employee> departmentList = new ArrayList<Employee>();

	}
	
	public Map<String, Employee> getLongestEmployedEmployeePerDepartementStream() {
		return employees.values().stream()
				.collect(Collectors.toMap(
						e -> e.getDepartment(), 
						e -> e,
						(e1, e2) -> e1.getYearsEmployed() > e2.getYearsEmployed() ? e1 : e2));
	}
 }

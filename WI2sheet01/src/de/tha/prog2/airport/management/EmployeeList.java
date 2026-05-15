package de.tha.prog2.airport.management;

import de.tha.prog2.airport.staff.Employee;
import de.tha.prog2.airport.staff.FlightAttendant;
import de.tha.prog2.airport.staff.GroundStaff;
import de.tha.prog2.airport.staff.Pilot;

public class EmployeeList {

	private ListNode head;

	private class ListNode {
		Employee employee;
		ListNode next;

		public ListNode(Employee employee) {
			this.employee = employee;
			this.next = null;
		}
	}

	public void add(Employee employee) {
		ListNode newNode = new ListNode(employee);

		if (head == null) {
			head = newNode;
		} else if (head.employee.getEmployeeId() > employee.getEmployeeId()) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode current = head;
			while (current.next != null && current.next.employee.getEmployeeId() < employee.getEmployeeId()) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	public void remove(int employeeId) {
		if (head == null) {
			return;
		}
		if (head.employee.getEmployeeId() == employeeId) {
			head = head.next;
			return;
		}
		ListNode current = head;
		while (current.next != null && current.next.employee.getEmployeeId() != employeeId) {
			current = current.next;
		}
		if (current.next != null)
			current.next = current.next.next;
	}

	public EmployeeList getPilots() {
		EmployeeList pilotList = new EmployeeList();
		ListNode current = head;
		while (current != null) {
			if (current.employee instanceof Pilot) {
				pilotList.add(current.employee);
			}
			current = current.next;
		}
		return pilotList;
	}

	public EmployeeList getGroundStaff() {
		EmployeeList groundStaffList = new EmployeeList();
		ListNode current = head;
		while (current != null) {
			if (current.employee instanceof GroundStaff) {
				groundStaffList.add(current.employee);
			}
			current = current.next;
		}
		return groundStaffList;
	}

	public EmployeeList getFlightAttendants() {
		EmployeeList flightAttendantList = new EmployeeList();
		ListNode current = head;
		while (current != null) {
			if (current.employee instanceof FlightAttendant) {
				flightAttendantList.add(current.employee);
			}
			current = current.next;
		}
		return flightAttendantList;
	}

	@Override
	public String toString() {
		if (head == null) {
			return "Liste ist leer.";
		}
		String ausgabe = "";
		ListNode current = head;
		while (current != null) {
			if (current.next != null) {
				ausgabe += current.employee.toString() + "\n";
				current = current.next;
			} else {
				ausgabe += current.employee.toString();
				current = current.next;
			}
		}
		return ausgabe;
	}
}

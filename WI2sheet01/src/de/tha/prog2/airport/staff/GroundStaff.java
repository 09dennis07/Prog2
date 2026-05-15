package de.tha.prog2.airport.staff;

	
	public class GroundStaff extends Employee {
		
		private int level;
		private Department department;
		private int overtimeHours;
		
		public GroundStaff(String lastName, String firstName, Department department) {
			super(lastName, firstName, department.getBaseSalary());
			this.department = department;
			level = 0;
		}
		
		public int addExtraTime() {
			if (overtimeHours <=3) {
				overtimeHours++;
			}
			return overtimeHours;
		}
		
		public int addExtraTime(int hours) {
			while (overtimeHours <= 3) {
				overtimeHours += hours;
			}
			return overtimeHours;
		}
		
		
		
		public void promote() {
			if (level == 0) {
				baseSalary = (baseSalary/100) * 105;
				level++;
				System.out.println(firstName + " " + lastName + " promoted to level " + level + ".");
			} 
			else if (level == 1) {
				baseSalary = (baseSalary/100) * 105;
				level++;
				System.out.println(firstName + " " + lastName + " promoted to level " + level + ".");
				}
			else if (level == 2) {
				baseSalary = (baseSalary/100) * 105;
				level++;
				System.out.println(firstName + " " + lastName + " promoted to level " + level + ".");
				} else {
				System.out.println(firstName + " " + lastName + " cannot be promoted further.");
			}
		}
		
		public void changeDepartment(Department department) {
			Department oldDepartment = this.department;
			this.department = department;
			level = 0;
			baseSalary = department.getBaseSalary();
			System.out.println(firstName + " " + lastName + " changed department from " + oldDepartment + " to " + this.department +".");
		}
		
		@Override
		public double calculateSalary() {
			return baseSalary + (baseSalary * (overtimeHours / 160.));
		}
		
		

		public static void main(String[] args) {
			
		}

}

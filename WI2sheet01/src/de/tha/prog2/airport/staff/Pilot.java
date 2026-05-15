package de.tha.prog2.airport.staff;

	public class Pilot extends Employee {
		
		private Rank rank;
		
		public Pilot(String lastName, String firstName, Rank rank) {
			super(lastName, firstName, rank.getBaseSalary());
			this.rank = rank;
		}
		
		public void promote() {
			if (rank == Rank.COPILOT) {
				baseSalary = rank.getBaseSalary();
				rank = Rank.FIRST_OFFICER;
				System.out.println(firstName + " " + lastName + " promoted to " + rank + ".");
			} 
			else if (rank == Rank.FIRST_OFFICER) {
				baseSalary = 9000;
				rank = Rank.CAPTAIN;
				System.out.println(firstName + " " + lastName + " promoted to " + rank + ".");
			} else {
				System.out.println(firstName + " " + lastName + " is already at highest rank.");
			}
		}
		
		public double calculateSalary() {
			return rank.getBaseSalary();
		}
		

		public static void main(String[] args) {
			
		}
		


}

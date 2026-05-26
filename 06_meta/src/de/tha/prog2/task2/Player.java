package de.tha.prog2.task2;

public class Player implements Comparable<Player>{
	
	private int points;
	private String name;
	
	public Player(String name) {
		this.name = name;
		this.points = 0;
	}
	
	public void recordPoints(int points) {
		this.points += points;
	}

	public int compareTo(Player p) {
		return Integer.compare(this.points, p.points);
	}
	
	public String toString() {
		return points + " - " + name;
	}

}

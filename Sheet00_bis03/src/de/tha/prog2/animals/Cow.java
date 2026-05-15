package de.tha.prog2.animals;

public class Cow implements Herbivore {
	
	private String Name;
	private int age;
	private int weight;
	
	public Cow(String Name, int age, int weight) {
		this.Name = Name;
		this.age = age;
		this.weight = weight;
	}
	
	@Override
	public int weight() {
		return this.weight;
	}

	@Override
	public boolean isHungry() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eatPlant() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "Kuh " + this.Name + " (Alter: " + this.age + " Jahre" + ", Gewicht: " + this.weight() + "kg)";
	}

}

package de.tha.prog2.animals;

public class Bear implements Omnivore{
	
	private String Name;
	private int age;
	private int weight;
	
	public Bear(String Name, int age, int weight) {
		this.Name = Name;
		this.age = age;
		this.weight = weight;
	}

	@Override
	public void eatPlant() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return 0;
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
	public void eatMeat() {
		// TODO Auto-generated method stub
		
	}

}

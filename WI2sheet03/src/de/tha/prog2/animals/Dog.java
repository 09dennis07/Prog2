package de.tha.prog2.animals;

public class Dog implements Carnivore {
	
	private String Name;
	private int age;
	private int weight;
	
	public Dog(String Name, int age, int weight) {
		this.Name = Name;
		this.age = age;
		this.weight = weight;
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

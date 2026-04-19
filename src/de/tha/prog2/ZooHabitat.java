package de.tha.prog2;

import de.tha.prog2.animals.Animal;
import de.tha.prog2.container.DoubleLinkedList;
import de.tha.prog2.exceptions.HabitatFullException;
import de.tha.prog2.exceptions.InvalidAnimalException;

public class ZooHabitat {
	
	private int maxCapacity;
	private DoubleLinkedList animals;

	public ZooHabitat(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.animals = new DoubleLinkedList();
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public int animals() {
		System.out.println(toString());
		return this.animals.size();
	}
	
	public void addAnimal(Animal a) throws HabitatFullException, InvalidAnimalException {
		if (animals.size() >= maxCapacity) {
			throw new HabitatFullException("Das Habitat ist bereits voll!");
		} else if (animals.size() != 0 && a.getClass() != animals.get(0).getClass()) {
			throw new InvalidAnimalException("Es können nur gleichartige Tiere in ein Habitat!");
		} else if (animals.contains(a)) {
			System.out.println("Tier bereits in Habitat!");
		} else {
			animals.add(a);			
		}
	}
	
	public boolean removeAnimal(Animal a) {
		return animals.remove(a);
	}
	
	@Override
	public String toString() {
	    return "Zoo-Habitat (Kapazität: " + maxCapacity + ")\n" +
	           "Aktuelle Tiere im Habitat:\n" + this.animals.toString();
	}
	
}

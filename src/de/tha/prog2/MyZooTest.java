package de.tha.prog2;

import de.tha.prog2.animals.Animal;
import de.tha.prog2.animals.Bear;
import de.tha.prog2.animals.Cow;
import de.tha.prog2.exceptions.HabitatFullException;
import de.tha.prog2.exceptions.InvalidAnimalException;

public class MyZooTest {
	public static void main (String[] args) {
	
	ZooHabitat habitat1 = new ZooHabitat(2);
	ZooHabitat habitat2 = new ZooHabitat(3);

	Animal cow1 = new Cow("Clara", 40, 400);
	Animal cow2 = new Cow("George", 12, 670);
	Animal cow3 = new Cow("Cleo", 7, 555);
	
	Animal bear1 = new Bear("Bruno", 67, 660);
	Animal bear2 = new Bear("Mars", 22, 700);
	Animal bear3 = new Bear("Bob", 3, 350);
	Animal bear4 = new Bear("Jon", 1, 200);
	
	
	try {
		habitat1.addAnimal(cow1);
	} catch(HabitatFullException hfe) {
		System.out.println(hfe.getMessage());
	} catch(InvalidAnimalException iae) {
		System.out.println(iae.getMessage());
	}
	try {
		habitat1.addAnimal(cow2);
	} catch(HabitatFullException hfe) {
		System.out.println(hfe.getMessage());
	} catch(InvalidAnimalException iae) {
		System.out.println(iae.getMessage());
	}
	
	System.out.println("Zoo Habitat 1 Add-Test (2 Tiere): ");
	System.out.println("");
	System.out.println(habitat1.toString());
	
	System.out.println("Zoo Habitat 1 Add-Test über Kapazität (+1 Tier): ");
	try {
		habitat1.addAnimal(cow3);
	} catch(HabitatFullException hfe) {
		System.out.println(hfe.getMessage());
	} catch(InvalidAnimalException iae) {
		System.out.println(iae.getMessage());
	}
	System.out.println("");
	habitat1.animals();
	
	System.out.println("Zoo Habitat 1 Add-Test falsche Tierart (-1 Tier für Kapazität und dann +1 Tier andere Art): ");
	habitat1.removeAnimal(cow2);
	try {
		habitat1.addAnimal(bear1);
	} catch(HabitatFullException hfe) {
		System.out.println(hfe.getMessage());
	} catch(InvalidAnimalException iae) {
		System.out.println(iae.getMessage());
	}
	}
	
}

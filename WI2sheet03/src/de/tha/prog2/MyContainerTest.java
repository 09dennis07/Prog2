package de.tha.prog2;

import de.tha.prog2.container.DoubleLinkedList;

public class MyContainerTest {
	
	public static void main(String[] args) {
		
		DoubleLinkedList list = new DoubleLinkedList();
		
        list.add("A");
        list.add("B");
        list.add("C");
        
        System.out.println("Add-Funktion Test (Stack-Prinzip): ");
        System.out.println(list.toString());
        System.out.println("Listengröße: ");
        System.out.println(list.size());
        
        System.out.println("");
        System.out.println("Get-Funktion Test (Indizes 0, 1, 2): ");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        
        System.out.println("");
        System.out.println("Get-Funktion Test (Index out of Bounds 3 und -1): ");
        
		try {
			list.get(3);
			System.out.println("IndexOutOfBounds nicht erkannt");
		} catch (IndexOutOfBoundsException ioobe) {
			 System.out.println("IndexOutOfBounds erkannt");
		}
		
		try {
			list.get(-1);
			System.out.println("IndexOutOfBounds nicht erkannt");
		} catch (IndexOutOfBoundsException ioobe) {
			 System.out.println("IndexOutOfBounds erkannt");
		}
		
        list.add("D");
        list.add("E");
        list.add("F");
        
        System.out.println("Stack-Vergrößerung für Remove-Test): ");
        System.out.println(list.toString());
        
        System.out.println("Remove-Funktion Test (Stack-Prinzip (Stack Anfang \"F\"): ");
        list.remove("F");
        System.out.println(list.toString());
        
        System.out.println("Remove-Funktion Test (Stack-Prinzip (Stack Mitte \"D\"): ");
        list.remove("D");
        System.out.println(list.toString());
        
        System.out.println("Remove-Funktion Test (Stack-Prinzip (Stack Ende \"A\"): ");
        list.remove("A");
        System.out.println(list.toString());
	
        System.out.println("Remove-Funktion Non-Existing Test: (A und D nochmal): ");
        list.remove("A");
        list.remove("D");
        System.out.println("Wurde A gelöscht? " + list.remove("A"));
        System.out.println("Wurde D gelöscht? " + list.remove("D"));
	}

}

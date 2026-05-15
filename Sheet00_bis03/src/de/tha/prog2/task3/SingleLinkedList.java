package de.tha.prog2.task3;

public class SingleLinkedList {
	
	private Node head;
	private int size;
	
	class Node {
		
		Object data;
		Node next;
		
		Node(Object data) {
			this.data = data;
			next = null;
		}
	}

}

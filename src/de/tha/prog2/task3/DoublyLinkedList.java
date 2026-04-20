package de.tha.prog2.task3;

public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	class Node {
		
		Node next;
		Node prev;
		Object data;
		
		Node(Object data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

}

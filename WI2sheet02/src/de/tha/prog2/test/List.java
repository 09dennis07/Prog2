package de.tha.prog2.test;

public class List extends AbstractContainer {

	protected Node head;
	protected Node tail;
	protected int size;

	class Node {

		Object data;
		Node next;

		Node(Object data) {
			this.data = data;
			this.next = null;
		}

	}

	@Override
	public boolean add(Object o) {

		Node newNode = new Node(o);

		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		this.size++;
		return true;
	}

	@Override
	public Object get(int i) {
		if (i < 0 || i >= size) {
			return null;
		}
		Node current = head;

		for (int zaehler = 0; zaehler < i; zaehler++) {
			current = current.next;
		}
		return current.data;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean remove(Object o) {
		Node current = head; 
		Node previous = null; 

		
		while (current != null) {

			boolean isMatch = (o == null && current.data == null) || (o != null && o.equals(current.data));

			if (isMatch) {

				if (previous == null) {
					head = current.next;
				} else {
					previous.next = current.next;
				}

				this.size--;
				return true;
			}

			previous = current;
			current = current.next;
		}

		return false;
	}

}

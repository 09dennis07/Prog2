package de.tha.prog2.test;

import de.tha.prog2.test.List.Node;

public class OptimizedList extends List {

	public boolean add(Object o) {

		Node newNode = new Node(o);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		this.size++;
		return true;
	}

	public void clear() {
		if (size != 0) {
			this.head = null;
			this.size = 0;
		}
	}
}

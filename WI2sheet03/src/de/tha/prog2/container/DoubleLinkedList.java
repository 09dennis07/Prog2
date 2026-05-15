package de.tha.prog2.container;

public class DoubleLinkedList extends AbstractContainer {

	protected Node head;
	protected Node tail;
	protected int size;

	class Node {
		Object data;
		Node next;
		Node prev;

		Node(Object data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}

	}

	@Override
	public boolean add(Object o) {
		Node newNode = new Node(o);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		this.size++;
		return true;
	}
	

	@Override
	public Object get(int i) {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (i < (size / 2)) {
			Node current = head;
			for (int j = 0; j < i; j++) {
				current = current.next;
			}
			return current.data;
		} else {
			Node current = tail;
			for (int k = size - 1; k > i; k--) {
				current = current.prev;
			}
			return current.data;
		}
	} 
	

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean remove(Object o) {
		if (head == null) {
			return false;
		}
		Node current = head;
		while (current != null) {
			boolean isMatch = (o == null && current.data == null) || (o != null && o.equals(current.data));
			if (isMatch) {
				if (current == head) {
					head = current.next;
					if (head != null) {
						head.prev = null;
					} else {
						tail = null;
					}
				} else if (current == tail) {
					tail = current.prev;
					tail.next = null;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				this.size--;
				return true;
			}
			current = current.next;
		}
		return false;
	}

}

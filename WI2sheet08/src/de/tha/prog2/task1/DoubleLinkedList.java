package de.tha.prog2.task1;

public class DoubleLinkedList<E> {

	private int size;
	private Node head, tail;

	class Node {

		private E data;
		private Node next;
		private Node prev;

		Node(E data) {
			this.next = null;
			this.prev = null;
			this.data = data;
		}
	}

	public boolean add(E data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		this.size++;
		return true;
	}

	public void insertAt(int index, E data) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (index == size) {
			this.add(data);
			return;
		}

		Node newNode = new Node(data);

		if (index == 0) {
			newNode.next = head;
			if (head != null) {
				head.prev = newNode;
			}
			head = newNode;
			if (tail == null) {
				tail = newNode;
			}
			this.size++;
			return;
		}

		Node current;
		if (index < (size / 2)) {
			current = head;
			for (int j = 0; j < index; j++) {
				current = current.next;
			}
		} else {
			current = tail;
			for (int k = size - 1; k > index; k--) {
				current = current.prev;
			}
		}

		newNode.next = current;
		newNode.prev = current.prev;
		current.prev.next = newNode;
		current.prev = newNode;

		this.size++;
	}

	public E get(int i) {
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

	public int size() {
		return this.size;
	}

	public boolean remove(E data) {
		if (head == null) {
			return false;
		}
		Node current = head;
		while (current != null) {
			boolean isMatch = (data == null && current.data == null) || (data != null && data.equals(current.data));
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

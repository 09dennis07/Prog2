package de.tha.prog2.task1;

import java.util.Enumeration;

public abstract class AbstractSet <E> implements Set<E>{
	
	public DoubleLinkedList <E> list = new DoubleLinkedList <E>();
	
	@Override
	public boolean test(E data) {
		for (int i = 0; i < list.size(); i++) {
			if (data.equals(list.get(i))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(E data) {
			if (this.test(data)) {
				list.remove(data);
				return true;
			}
		return false;
	}

	@Override
	public Enumeration<E> elements() {
		return;
	}
	
}

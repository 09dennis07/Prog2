package de.tha.prog2.task1;

public class OrderedSet<E extends Comparable<E>> extends AbstractSet<E> {

	@Override
	public boolean add(E data) {
		if (this.test(data)) {
			return false;
		} 

		for (int i = 0; i < list.size(); i++) {
					if (data.compareTo(list.get(i)) < 0) {
						list.insertAt(i, data);
						return true;
					}
				}
		list.add(data);
		return true;
	}

}

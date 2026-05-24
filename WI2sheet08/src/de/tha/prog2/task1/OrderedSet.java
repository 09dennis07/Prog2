package de.tha.prog2.task1;

public class OrderedSet<E extends Comparable<E>> extends AbstractSet<E> {

	@Override
	public boolean add(E data) {
		if (this.test(data)) {
			return false;
		} else {
			if (list.size() == 0) {
				list.add(data);
			} else {
				for (int i = 0; i < list.size(); i++) {
					if (data.compareTo(list.get(i)) < 0) {
						list.insertAt(i, data);
						return true;
					}

				}
			}

		}
		list.addLast(data);
		return true;
	}

}

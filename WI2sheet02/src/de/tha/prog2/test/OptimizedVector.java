package de.tha.prog2.test;

public class OptimizedVector extends Vector {

	public boolean add(Object o) {
		if (data.length == this.size) {
			int newSize = (this.size == 0) ? 1 : this.size * 2;
			Object[] dataNew = new Object[newSize];
			for (int i = 0; i < data.length; i++) {
				dataNew[i] = data[i];
			}
			dataNew[size] = o;
			this.data = dataNew;
			this.size++;
			return true;
		} else {
			data[size] = o;
			this.size++;
			return true;
		}
	}

	public void clear() {
		if (size != 0) {
			this.data = new Object[0];
			this.size = 0;
		}

	}

}

package de.tha.prog2.test;

public class Vector extends AbstractContainer {
	
	protected Object[] data = new Object[0];
	protected int size = 0;
	

	@Override
	public boolean add(Object o) {
		Object[] dataNew = new Object[size+1]; 
		for (int i = 0; i < data.length; i++) {
			dataNew[i] = data[i];
		}
		dataNew[size] = o;
		this.data = dataNew;
		this.size++;
		return true;
	}

	@Override
	public Object get(int i) {
		if (i >= size || i < 0) {
			return null;
		} else {
			return data[i];						
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean remove(Object o) {
		int removed = -1;
		for (int i = 0; i < size; i++) {
			if (o.equals(data[i])) {
				removed = i;
				break;
			}
		}
		if (removed == -1) {
			return false;		
		}
		
		Object[] dataNew2 = new Object[size-1];
		for (int i = 0; i < dataNew2.length; i++) {
			if ((o == null && data[i] == null) || (o != null && o.equals(data[i]))){
				dataNew2[i] = data[i];
			} else {
				dataNew2[i] = data[i+1];				
			}
		}
		this.data = dataNew2;
		this.size--;
		return true;
	}

}

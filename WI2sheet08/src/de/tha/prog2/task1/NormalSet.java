package de.tha.prog2.task1;

public class NormalSet<E> extends AbstractSet<E>{
	
	@Override
	public boolean add(E data) {
			if (!this.test(data)) {
				list.add(data);
				return true;
			}
		return false;
	}
	
	

}

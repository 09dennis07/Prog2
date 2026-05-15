package de.tha.prog2.test;

import de.tha.prog2.Container;

public abstract class AbstractContainer implements Container {

	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}

		if (!(o instanceof Container)) {
			return false;
		}

		Container andererContainer = (Container) o;

		if (this.size() != andererContainer.size()) {
			return false;
		}

		Object[] objects1 = this.toArray();
		Object[] objects2 = andererContainer.toArray();

		for (int i = 0; i < objects1.length; i++) {
			if (objects1[i] != objects2[i]) {
				return false;
			}
		}
		
		return true;

	}
	
	public String toString() {
		String output = "";
		
		for (int i = 0; i < this.size(); i++) {
			output += this.get(i) + "\n";
		}
		return output;
	}

}

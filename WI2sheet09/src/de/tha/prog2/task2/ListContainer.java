package de.tha.prog2.task2;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ListContainer implements Serializable {
	private List<String> stringList;
	private List<Integer> integerList;
	
	public ListContainer(List<String> stringList, List<Integer> integerList) {
		this.stringList = stringList;
		this.integerList = integerList;
	}
	
	public List<String> getStringList() {
		return stringList;
	}
	
	public List<Integer> getIntegerList() {
		return integerList;
	}
	
	public boolean equals(Object o) {
		if (o instanceof ListContainer listContainer) {
			return stringList.containsAll(listContainer.getStringList()) &&
					listContainer.getStringList().containsAll(stringList) &&
					integerList.containsAll(listContainer.getIntegerList()) &&
					listContainer.getIntegerList().containsAll(integerList);
		}
		return false;
	}
}

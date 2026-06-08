package de.tha.task03;

import java.util.ArrayList;
import java.util.List;

public class FilterChain<T> {
	
	protected List<Filter<T>> filters;
	
	public FilterChain() {
		this.filters = new ArrayList<>();
	}
	
	
	
	

}

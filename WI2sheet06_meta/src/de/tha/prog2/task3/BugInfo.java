package de.tha.prog2.task3;

import java.lang.reflect.Member;

public class BugInfo {
	
	private Class<?> clazz;
	private Class<?> outer;
	private Member method;
	private Bug.Type type;
	private String description;
	
	
	public BugInfo(Class<?> clazz, Class<?> outer, Member method, Bug.Type type, String description) {
		this.clazz = clazz;
		this.outer = outer;
		this.method = method;
		this.type = type;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
	    String clazzName = (clazz == null) ? "null" : clazz.getName();
	    String outerName = (outer == null) ? "null" : outer.getName();
	    String methodName = (method == null) ? "null" : method.toString();
	    
	    return clazzName + "\t" + outerName + "\t" + methodName + "\t" + type + "\t" + description;
	}
}

package de.tha.prog2.task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class BugLister {

	private List<BugInfo> bugs = new LinkedList<>();

	public List<BugInfo> getBugInfos(Class<?> clazz) {
		if (clazz.isAnnotationPresent(Bug.class)) {
			Bug bugAnnotation = clazz.getAnnotation(Bug.class);
			Class<?> outer = clazz.getDeclaringClass();
			BugInfo info = new BugInfo(clazz, outer, null, bugAnnotation.type(), bugAnnotation.description());
			this.bugs.add(info);
		}

		for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
			if (constructor.isAnnotationPresent(Bug.class)) {
				Bug bugAnnotation = constructor.getAnnotation(Bug.class);
				Bug.Type type = bugAnnotation.type();
				String description = bugAnnotation.description();
				Class<?> outer = clazz.getDeclaringClass();
				BugInfo info = new BugInfo(clazz, outer, constructor, type, description);
				this.bugs.add(info);
			}
		}
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.isAnnotationPresent(Bug.class)) {
				Bug bugAnnotation = method.getAnnotation(Bug.class);
				Bug.Type type = bugAnnotation.type();
				String description = bugAnnotation.description();
				Class<?> outer = clazz.getDeclaringClass();
				BugInfo info = new BugInfo(clazz, outer, method, type, description);
				this.bugs.add(info);
			}
		}
		for (Class<?> innerclass : clazz.getDeclaredClasses()) {
			this.getBugInfos(innerclass);
		}
		return this.bugs;
	}

	public String toString() {
		String ausgabe = "";
		for (BugInfo bugs : this.bugs) {
			ausgabe += bugs.toString() + "\n";
		}
		return ausgabe;
	}

	public static void main(String[] args) {

	}

}

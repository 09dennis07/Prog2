package collections;

import java.util.*;

public class CollectionTest {
	static boolean dontLike(Object o) {
		if (o instanceof String)
			return (((String) o).length() > 5);
		return false;
	}

	//@SuppressWarnings("rawtypes")
	static void filter(Collection c) {
		Iterator it = c.iterator();
		while (it.hasNext())
			if (dontLike(it.next()))
				it.remove();
	}

	//@SuppressWarnings("rawtypes")
	static void visitElements(Collection c) {
		for (Object o : c)
			System.out.println("visited: " + o);
	}

	//@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void replace(List list, Object value, Object newValue) {
		ListIterator it = list.listIterator();
		while (it.hasNext()) {
			if (value == null ? it.next() == null : value.equals(it.next()))
				it.set(newValue);
		}
	}

	//@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("Suse");
		v.add("Walter");
		v.add("Werner");
		v.add("Gitte");
		v.add("Suse");
		System.out.println(v);

		visitElements(v);

		// filtern
		filter(v);
		System.out.println(v);

		// entfernen eines Objekts mit Duplikaten
		System.out.println("Suse(s) entfernt: " + v.removeAll(Collections.singleton("Suse")));
		System.out.println(v);

		v.add("Werner");
		v.add("Gitte");
		v.add("Suse");
		System.out.println(v);

		// Element ersetzen
		replace(v, "Gitte", "Hilde");

		System.out.println(v);

		// Teilliste erzeugen
		List sublist = v.subList(1, 3);
		System.out.println("SubList: " + sublist);
		// Suchen in der Teilliste
		int i = sublist.indexOf("Hilde"); // index in der Teilliste!!
		System.out.println("Hilde hat den Index: " + i);

		// Loeschen eines Bereichs
		v.subList(1, 3).clear();
		System.out.println(v);

		v.add("Gitte");
		v.add("Suse");
		System.out.println(v);

		HashSet set1 = new HashSet(v);
		System.out.println("set1: " + set1);
		HashSet set2 = new HashSet();
		set2.add("Gitte");
		set2.add("Harald");
		set1.retainAll(set2);

		System.out.println(set1);

		// fail fast test
		ListIterator l = v.listIterator();
		v.add("Hedi");
		l.next();
	}
}
package generics;

import java.util.*;

public class CollectionTest {

    static boolean dontLike(Object o) {
        if (o instanceof String)
            return (((String) o).length() > 5);
        return false;
    }

    static void filter(Collection<?> c) {
        Iterator<?> it = c.iterator();
        while (it.hasNext())
            if (dontLike(it.next()))
                it.remove();
    }

    static void visitElements(Collection<String> c) {
        for (String o : c)
            System.out.println("visited: " + o);
    }

    public static <T> void replace(List<T> list, T value, T newValue) {
        ListIterator<T> it = list.listIterator();
        while (it.hasNext()) {
        	if (value == null ? it.next() == null : value.equals(it.next()))
                it.set(newValue);
        }
    }
    
    public static void testNumberVsInteger(List<Number> list, Number d) {
    	list.add(d);
    }
    
    public static void testIntegerVsNumber(List<Integer> list, Integer d) {
    	list.add(d);
    }
    
    public static void main(String[] args) {
        List<String> v = new Vector<>();
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
        System.out.println("Suse(s) entfernt: "
                + v.removeAll(Collections.singleton("Suse")));
        System.out.println(v);

        v.add("Werner");
        v.add("Gitte");
        v.add("Suse");
        System.out.println(v);

        // Element ersetzen
        replace(v, "Gitte", "Hilde");

        System.out.println(v);

        // Teilliste erzeugen
        List<String> sublist = v.subList(1, 3);

        // Suchen in der Teilliste
        int i = sublist.indexOf("Hilde"); // index in der Teilliste!!
        System.out.println("Hilde hat den Index: " + i);

        // Loeschen eines Bereichs
        v.subList(1, 3).clear();
        System.out.println(v);

        v.add("Gitte");
        v.add("Suse");
        System.out.println(v);
        
        System.out.println("Before HashSet");

        Set<String> set1 = new TreeSet<>((o1, o2) -> -o1.compareTo(o2));

        set1.addAll(v);
        System.out.println(set1);
        Set<String> set2 = new HashSet<String>();
        set2.add("Gitte");
        set2.add("Harald");
        set1.retainAll(set2);

        System.out.println(set1);

        // fail fast test
        ListIterator<String> l = v.listIterator();
        v.add("Hedi");
        l.next();
        
        // Example for Generics and Inheritance: Inheritance is not applied to generic parameters
        List<Integer> integerList = new ArrayList<Integer>();
        List<Number> numberList = new ArrayList<Number>();
        testNumberVsInteger(numberList, Integer.valueOf(0)); 
        // testNumberVsInteger(integerList, Integer.valueOf(0)); // does this work?
        
        //testIntegerVsNumber(numberList, Integer.valueOf(0)); // does this work?
        testIntegerVsNumber(integerList, Integer.valueOf(0));
    }

    private class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return -o1.compareTo(o2);
        }
    }


}
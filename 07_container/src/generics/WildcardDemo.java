package generics;

import java.util.*;

public class WildcardDemo {
    
    public static void printStringLengths(Collection<String> collection) {
        System.out.println("Print String lengths:");
        for (String s : collection) {
            System.out.println(s + ":" +s.length());
        } 
    }
    
    public static void printCollection(Collection<?> collection) {
//        collection.add(Integer.valueOf(3)); // test what happens if you uncomment this
    	for (Object o : collection) {
            System.out.println(o);
        } 
        
    }
    
    public static void printCollectionUntyped(Collection collection) {
        collection.add(Integer.valueOf(5));
        collection.add("Foobar");
        for (Object o : collection) {
            System.out.println(o);
        } 
    }

    
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Hallo");
        list.add("Guten Morgen");
        list.add("Gruezii");
        
        System.out.println("------------------- printCollection() ");
        printCollection(list);
        System.out.println("------------------- printStringLengths() ");
        printStringLengths(list);
        System.out.println("------------------- printCollectionUntyped() ");
        printCollectionUntyped(list);
        System.out.println("------------------- printStringLengths() (after modification by printCollectionUntyped() ");
        printStringLengths(list);
        
        System.out.println("------------------- creating checkedList");
		List<String> checkedList = Collections.checkedList(list,String.class);
		try { 
			// checkedList does not allow 
			printCollectionUntyped(checkedList);
		} catch  (Exception e) {
			e.printStackTrace();
		}
		
    }
}

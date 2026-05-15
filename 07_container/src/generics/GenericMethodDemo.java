package generics;

import java.util.*;

public class GenericMethodDemo {
    
    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o); 
            System.out.println("fromArrayToCollection - adding " + o.getClass());
        }
    }
    
    static <T> void fromCollectionToArray(Collection<T> c, T[] a) { 
        int i = 0;
        for (T o : c) { 
            a[i++] = o;
            System.out.println("fromCollectionToArray - adding " + o.getClass());

        }
    }

    public static void main(String[] args) {
        String[] sa = {"Karl", "Heinz"};
        String[] sta = new String[10];
        Collection<String> sc = new ArrayList<String> ();
        sc.add("Ina");
        Collection<Object> oc = new ArrayList<Object> ();
        oc.add(5);  //??? Alternative oc.add("Fritz");

        
        fromArrayToCollection(sa,sc);  // T inferred to be ?
        fromCollectionToArray(sc,sta);  // T inferred to be ?
        System.out.println(sc);
        System.out.println(Arrays.toString(sta));
        
        fromArrayToCollection(sa,oc);  // T inferred to be ?
        fromCollectionToArray(oc,sta);  // T inferred to be ?
        
        System.out.println(oc);
    }
}

package hash;

import java.util.*;

public class HashtableTest {
	public static void main(String[] args) {
        Hashtable htab = new Hashtable(10, 1.0f);
        String str = "first";
        Integer one = Integer.valueOf(1);
        htab.put(str, one);
        htab.put("second", Double.valueOf(2.0));
        htab.put("third", new Vector());
        //htab.put(Integer.valueOf(4), new Vector()); // geht das?
        
        System.out.println(htab);

        //str = "fourth"; // was aendert sich dadurch?
        System.out.println("contains  key " + str + ":" + htab.containsKey(str));
        System.out.println("  has value:" + htab.get(str));

        System.out.println("contains value " + one + ":" + htab.contains(one));

        System.out.println("htab:" + htab);

        htab.remove("third");
        System.out.println("htab:" + htab);

        htab.put(new String("first"), Double.valueOf(1.0)); // was passiert?
        System.out.println("htab:" + htab);
    }
}
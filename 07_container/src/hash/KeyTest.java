package hash;

import java.util.*;

class HashKey {
    private String str;

    public HashKey(String str) {
        this.str = str;
    }

    public String toString() {
        return str;
    }
}

public class KeyTest {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        System.out.println("start");
        Hashtable htab = new Hashtable(10, 1.0f);
        htab.put(new HashKey("first"), Integer.valueOf(1));
        htab.put(new HashKey("second"), Double.valueOf(2.0));

        System.out.println("htab:" + htab);
        htab.put(new HashKey("first"), Double.valueOf(1.0)); // was passiert?
        System.out.println("htab:" + htab);
        System.out.println("htab contains first:" + htab.containsKey(new HashKey("first")));
    }
}
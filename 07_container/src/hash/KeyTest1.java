package hash;

import java.util.*;

class HashKey1 {
    private String str;

    public HashKey1(String str) {
        this.str = str;
    }

    public String toString() {
        return str;
    }

    @Override
    public int hashCode() {
        return str.hashCode();
    }
}

public class KeyTest1 {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        Hashtable htab = new Hashtable(10, 1.0f);
        htab.put(new HashKey1("first"), Integer.valueOf(1));
        htab.put(new HashKey1("second"), Double.valueOf(2.0));

        System.out.println("htab:" + htab);
        htab.put(new HashKey1("first"), Double.valueOf(1.0)); // was passiert?
        System.out.println("htab:" + htab);
        System.out.println("value for key \"first\":" + htab.get(new HashKey1("first")));
    }
}
package hash;

import java.util.*;

class HashKey2 {
    private String str;

    public HashKey2(String str) {
        this.str = str;
    }

    public String toString() {
        return str;
    }

    @Override
    public int hashCode() {
        return str.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HashKey2))
            return false;
        return (str.equals(((HashKey2) o).str));
    }
}

public class KeyTest2 {
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
        Hashtable htab = new Hashtable(10, 1.0f);
        htab.put(new HashKey2("first"), Integer.valueOf(1));
        htab.put(new HashKey2("second"), Double.valueOf(2.0));

        System.out.println("htab:" + htab);
        htab.put(new HashKey2("first"), Double.valueOf(1.0)); // was passiert?
        System.out.println("htab:" + htab);
        System.out.println("value for key \"first\":" + htab.get(new HashKey2("first")));
    }
}
package generics;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Hashtable<String, Integer> htab = new Hashtable<String, Integer>(10,1.0f);
        String str = "first";
        Integer one = Integer.valueOf(1);
        htab.put(str, one);
        htab.put("second", 2);
        htab.put("third", 3);

        Map<String, Integer> map = htab;

        System.out.println("map:" + map);
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + ": " + value);
        }

        // alternative
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String key = e.getKey();
            int value = e.getValue();
            System.out.println(key + ": " + value);
        }
    }
}
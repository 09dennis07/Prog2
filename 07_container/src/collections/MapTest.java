package collections;

import java.util.*;

public class MapTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Hashtable htab = new Hashtable(10, 1.0f);
		String str = "first";
		Integer one = Integer.valueOf(1);
		htab.put(str, one);
		htab.put("second", Double.valueOf(2.0));
		htab.put("third", new Vector());

		Map map = htab;
		System.out.println("map:" + map);
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			Object key = e.getKey();
			Object value = e.getValue();
			System.out.println(key + ": " + value);
		}
	}
}
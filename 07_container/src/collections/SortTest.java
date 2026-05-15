package collections;

import java.util.*;

public class SortTest {
	public static void main(String args[]) {
		List<String> l = Arrays.asList(args);
		Collections.sort(l, (o1, o2) -> -o1.compareTo(o2));
		System.out.println(l);
	}
}
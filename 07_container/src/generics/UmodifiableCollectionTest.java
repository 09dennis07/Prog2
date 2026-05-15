package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UmodifiableCollectionTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		System.out.println("ArrayList: " + list);
		
		List<Integer> unmodifiableList = Collections.unmodifiableList(list);
		System.out.println("UnmodifiableList: " + unmodifiableList);
		unmodifiableList.add(3);
	}
}

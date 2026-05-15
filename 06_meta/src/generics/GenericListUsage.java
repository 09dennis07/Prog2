package generics;

import java.util.Arrays;
import java.util.List;

class A {
	public String toString() { return "Ich bin eine Instanz von A"; }
}

public class GenericListUsage {
	public static void printListObject(List<Object> li) {
	    for (Object elem : li)
	        System.out.println(elem + " ");
	    System.out.println();
	}
	
	public static void printList(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}
	
	public static void main(String args[]) {
		List<Integer> li = Arrays.asList(1, 2, 3, 4);
		List<A> li2 = Arrays.asList(new A(), new A());
		
		//printListObject(li); // Compiler Error: This is not a list of Objects
		printList(li);
		//printObject(li2); // Compiler Error: this is not a list of Objects
		printList(li2);
	}
}

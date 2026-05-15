package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class VectorArrayListPerformance {
	public static final int SIZE = 1000;
	//public static final int SIZE = 10000;
	//public static final int SIZE = 100000;
	//public static final int SIZE = 1000000;
	//public static final int SIZE = 10000000;
	public static final Random random = new Random();
	
	public static void testListAdd(List<Integer> li) {
		long startTime, endTime;
		
		startTime = System.nanoTime();		
		for (int i = 0; i != SIZE; ++i) {
			li.add(0);
		}
		endTime = System.nanoTime();

		System.out.format("Inserting %d integers into %10s took: %10.2f milliseconds\n", SIZE, li.getClass().getSimpleName(), (endTime-startTime)/(double)1_000_000);
	}
	
	public static void testListAccess(List<Integer> li) {
		long startTime, endTime;
		int counter = 0;
		
		startTime = System.nanoTime();		
		for (int i = 0; i != SIZE; ++i) {
			li.get(i);
			
			/*
			counter++;
			if (counter % 1000 == 0) {
				System.out.println("Accessing " + counter + "th element ...");
			}
			*/
		}
		endTime = System.nanoTime();

		System.out.format("Accessing %d integers from %10s took: %10.2f milliseconds\n", SIZE, li.getClass().getSimpleName(), (endTime-startTime)/(double)1_000_000);
		
	}
	
	public static void testListRemove(List<Integer> li) {
		long startTime, endTime;
		
		startTime = System.nanoTime();
		int counter = 0;
		while (!li.isEmpty()) {
			li.remove(0);
			
			/*
			counter++;
			if (counter % 1000 == 0) {
				System.out.println("Removing " + counter + "th element ...");
			}
			*/
		}
		endTime = System.nanoTime();
		System.out.format("Removing %d integers from %10s took: %10.2f milliseconds\n", SIZE, li.getClass().getSimpleName(), (endTime-startTime)/(double)1_000_000);

	}
	
	public static void main(String args[]) {
		List<Integer> vector = new Vector<>();
		List<Integer> arrayList = new ArrayList<>();
		List<Integer> linkedList = new LinkedList<>();
		
		System.out.println("Adding tests without preallocation ...");
		testListAdd(vector);
		testListAdd(arrayList);
		testListAdd(linkedList);
		
		System.out.println("\nAdding tests with preallocation ... (not possible for LinkedList) ...");
		vector = new Vector<>(SIZE);
		arrayList = new ArrayList<>(SIZE);
		testListAdd(vector);
		testListAdd(arrayList);
		
		System.out.println("\nAccess Tests ...");
		testListAccess(vector);
		testListAccess(arrayList);
		testListAccess(linkedList);
		
		System.out.println("\nTesting removal of elements ...");
		testListRemove(linkedList);
		testListRemove(arrayList);
		testListRemove(vector);
	}
}

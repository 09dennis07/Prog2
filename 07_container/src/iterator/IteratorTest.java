package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
	public static void main(String args[]) {
		List<Integer> li = Arrays.asList(1, 2, 3, 4);
		
		Iterator<Integer> iter = li.iterator();
		while (iter.hasNext()) {
			System.out.println("Wert: " + iter.next());
		}
		
		// Automatically created internal iterator
		System.out.println("Und jetzt nochmal mit internem Iterator:");
		for (Integer i : li) {
			System.out.println("Wert:" + i);
		}
		
		// Was passiert wenn Werte aus Liste gelöscht werden?
		System.out.println("Jetzt löschen wir Werte...");
		iter = li.iterator();
		iter.next(); 
		try {
			iter.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// jetzt nochmal mit einer ArrayList
		ArrayList<Integer> arraylist = new ArrayList<>();
		arraylist.addAll(li);
		System.out.println("Lösche erstes Element aus Liste ...");
		iter = arraylist.iterator();
		iter.next(); 				// Sind jetzt auf dem ersten Element;
		iter.remove(); 				// Jetzt wird gelöscht
		System.out.println("Und jetzt schauen wir uns nochmal alle Elemente an:");
		for (Integer i : arraylist) {
			System.out.println("Wert: " + i);
		}
		
		// Löschen während wir durch die Liste gehen
		arraylist = new ArrayList<>();
		arraylist.addAll(li);
		iter = arraylist.iterator();
		while (iter.hasNext()) {
			System.out.println("Werte im Array: " + arraylist);
			System.out.println("Lösche folgenden Wert: " + iter.next());
			iter.remove();
		}


		// Löschen während wir durch die Liste gehen
		arraylist = new ArrayList<>();
		arraylist.addAll(li);
		for (Integer i : arraylist) {
			try {
				arraylist.remove(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}
}

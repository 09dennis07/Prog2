package übung07;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class TextProviderTest {

	public static void main(String[] args) {

		TextProvider txtP = new TextProvider();
		TextProvider txtP2 = new TextProvider();
		TextAnalyser txtA = new TextAnalyser();
		
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> map2 = new TreeMap<>(Collections.reverseOrder());
		 
//		for (String line : txtP) { System.out.println(line); } 
		
		
		System.out.println("HashMap mit aufsteigender Sortierung (zufällig da Char Charaktere)");
		txtA.countChars(map, txtP);
		System.out.println("Treemap mit absteigender Sortierung (reverseOrder)");
		txtA.countChars(map2, txtP2);
		

	}
	
}
	

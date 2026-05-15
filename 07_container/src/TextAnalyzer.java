import java.util.Collections;
import java.util.Map;

import de.tha.prog2.tools.TextProvider;

class TextAnalyser {

	public void countChars(Map<Character, Integer> map, TextProvider provider) {
		String text = null;
		for (String line : provider) {
			text = line.toLowerCase();
			char[] textChars = text.toCharArray();

			for (int i = 0; i < textChars.length; i++) {
				if (textChars[i] >= 'a' && textChars[i] <= 'z') {
					if (!map.containsKey(textChars[i])) {
						map.put(textChars[i], 1);
					} else {
						int counter = map.get(textChars[i]);
						map.put(textChars[i], counter + 1);
					}
				}

			}
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}
		
		int max = 0;
		char maxKey = Character.MIN_VALUE;
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				maxKey = entry.getKey();
			}
		}
		System.out.println("Häufigster Buchstabe " +  maxKey + ": " + "(" + max + ")");
	}

}
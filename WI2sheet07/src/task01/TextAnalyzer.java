package task01;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import tha.prog2.tools.TextProvider;

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
		
		Map.Entry<Character, Integer> maxEntry = Collections.max(map.entrySet(), Map.Entry.comparingByValue());
		
		System.out.println("Häufigster Buchstabe " + maxEntry.getKey() + ": " + "(" + maxEntry.getValue() + ")");
	}

}
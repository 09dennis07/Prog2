package de.tha.prog2.task3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import de.tha.prog2.task3.Word.Position;

public class WordCounter {
	
	Map<Word, Integer> wordTreeMap = new TreeMap<>();
	Map<Word, Integer> wordMap = new HashMap<>();

    // Reader zum Einlesen der Zeichenquelle
    private Reader reader;

    // Konstruktor speichert den uebergebenen Reader
    public WordCounter(Reader reader) {
        this.reader = reader;
    }

    public void read() throws IOException {
    	
    	 

        // BufferedReader ermoeglicht das zeilenweise Lesen
        BufferedReader br = new BufferedReader(reader);

        // Erste Zeile einlesen
        String line = br.readLine();

        // Solange noch Zeilen vorhanden sind
        while (line != null) {

            // TODO:
            // - Zeile in Woerter zerlegen
        String[] words = line.split(" ");
            // - Position der Woerter bestimmen
        	// - Word-Objekte erzeugen
        int positionNr;
        Position position;
        for (int i = 0; i < words.length; i++) {
        	if (words[i].trim().isEmpty()) {
                continue; 
            }
        	if (i < words.length / 2) {
        		position = Position.START;       	
        		} else if (i == words.length / 2) {
        			position = Position.MIDDLE;    
        		} else {
        			position = Position.END;
        		}
        	Word word = new Word(words[i], position);
        	// - Woerter in der Map zaehlen
        	wordMap.merge(word, 1, Integer::sum);
        	wordTreeMap.merge(word, 1, Integer::sum);
        }
        

            System.out.println(line);

            // Naechste Zeile einlesen
            line = br.readLine();
        }
    }
    
    public Map<Word, Integer> getWordMap() {
    	return this.wordMap;
    }
    
    public Map<Word, Integer> getWordTreeMap() {
    	return this.wordTreeMap;
    }

    public static void main(String[] args) throws IOException {

        // Datei oeffnen und Reader erzeugen (Decorator Pattern!)
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(
                    new File("src/de/tha/prog2/task3/dummy.txt")
                )
            )
        );

        // WordCounter erzeugen
        WordCounter counter = new WordCounter(reader);

        // Text einlesen und verarbeiten
        counter.read();
        
        System.out.println(counter.getWordMap());
        System.out.println(counter.getWordTreeMap());
    }
}
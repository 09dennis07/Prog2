package de.tha.prog2.task2;

public class HighScore {
	
	protected Player[] entries;
	
	public HighScore() {
		this.entries = new Player[10];
	}
	
	
	public void recordEntry(Player p) {
		
		for (int i = 0; i < entries.length; i++) {
			if (entries[i] == null || entries[i].compareTo(p) < 0) {
				for (int j = entries.length - 1; j > i; j--) {
					entries[j] = entries[j-1];
				}
				entries[i] = p;
				break;
			}
		}
	}
	
	public String toString() {
		String ausgabe = "";
		ausgabe += "** HIGH SCORE **" + "\n";
		for (int i = 0; i < entries.length && entries[i] != null; i++) {
			ausgabe += entries[i].toString() + "\n";
		}
		return ausgabe;
	}
}

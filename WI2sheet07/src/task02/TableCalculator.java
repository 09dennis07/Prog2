package task02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import tha.prog2.tools.Game;
import tha.prog2.tools.GameDataProvider;

public class TableCalculator {

	public static void main(String[] args) throws IOException {

		GameDataProvider gdp = new GameDataProvider();

		Map<String, GameData> vereine = new HashMap<>();

		Scanner scanner = new Scanner(System.in);

		int gameday;

		do {
			System.out.println("Geben Sie den gewünschten Spieltag ein: ");
			gameday = scanner.nextInt();
		} while (gameday < 1 || gameday > gdp.getMatchDays());

		for (int i = 1; i <= gameday; i++) {
			ArrayList<Game> matchdayGames = gdp.getGames(i);
			for (Game games : matchdayGames) {
				if (!vereine.containsKey(games.homeTeam)) {
					vereine.put(games.homeTeam, new GameData(games.homeTeam));
				}
				GameData home = vereine.get(games.homeTeam);
				home.addResult(games.homeGoals, games.awayGoals);
			}
			for (Game games : matchdayGames) {
				if (!vereine.containsKey(games.awayTeam)) {
					vereine.put(games.awayTeam, new GameData(games.awayTeam));
				}
				GameData away = vereine.get(games.awayTeam);
				away.addResult(games.awayGoals, games.homeGoals);
			}
		}

		ArrayList<GameData> tabelle = new ArrayList<>(vereine.values());

		tabelle.sort((team1, team2) -> {
			if (team1.getPoints() != team2.getPoints()) {
				return Integer.compare(team1.getPoints(), team2.getPoints());
			} else if (team1.getGoaldiff() != team2.getGoaldiff()) {
				return Integer.compare(team1.getGoaldiff(), team2.getGoaldiff());
			} else {
				return Integer.compare(team1.getGoals(), team2.getGoals());
			}
		});
		
		Collections.reverse(tabelle);

		System.out.println("====== Tabelle nach Spieltag "+ gameday + " ======");

		// Kopfzeile: Alles Text (%s), alle Spalten für S, U, N bekommen großzügig 2 Zeichen Platz
		System.out.printf("%-3s | %-24s | %2s | %2s | %2s | %2s | %6s | %4s | %3s%n",
		        "Pl.", 
		        "Verein", 
		        "Sp", 
		        "S", 
		        "U", 
		        "N", 
		        "Tore", 
		        "Diff", 
		        "Pkt");
		System.out.println("------------------------------------------------------------------------");

		for (int i = 0; i < tabelle.size(); i++) {
		    GameData team = tabelle.get(i);
		    int platz = i + 1;
		    
		    // Daten: Platzierung und Name als String (%s), aber die ganzen Statistiken als Zahl (%d)!
		    // Die Platzhalter (%2d, %6s etc.) sind exakt identisch mit der Kopfzeile!
		    System.out.printf("%-3s | %-24s | %2d | %2d | %2d | %2d | %6s | %4d | %3d%n",
		            platz + ".", 
		            team.getName(), 
		            team.getPlayedGames(), 
		            team.getWins(),
		            team.getDraws(),
		            team.getLosses(),
		            team.getGoals() + ":" + team.getGgoals(),
		            team.getGoaldiff(),
		            team.getPoints());
		}
	}
}

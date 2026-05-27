package task02;

import java.util.ArrayList;
import java.util.Map;

import tha.prog2.tools.Game;
import tha.prog2.tools.GameDataProvider;

public class GameData {
	
	private String name;
	private int playedGames;
	private int wins;
	private int draws;
	private int losses;
	private int goals;
	private int ggoals;
	private int goaldiff;
	private int points;
	
	public void calculateGameday(int gameDay) {
		GameDataProvider gdp = new GameDataProvider();
		Game game = null;
		ArrayList<Game> games = new ArrayList<Game>[gameDay];
		int i = 1;
		while (i <= gameDay) {
			for (Map<Integer, ArrayList<Game>> games : games.entrySet() {
				gdp.getGames(i);
				i++;
			}
		}
		for (int j = 0; j < games.length; j++) {
			Game(games[j]);
		}
	}

}

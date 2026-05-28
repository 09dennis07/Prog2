package task02;

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
	
	public GameData(String name) {
		this.name = name;
	}
	
	public void addResult(int erzielteTore, int gegentore) {
		if (erzielteTore > gegentore) {
			points += 3;
			wins++;
		} else if (erzielteTore == gegentore) {
			points += 1;
			draws++;
		} else {
			losses++;
		}
		goals += erzielteTore;
		ggoals += gegentore;
		playedGames++;
		goaldiff = goals - ggoals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayedGames() {
		return playedGames;
	}

	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int draws) {
		this.draws = draws;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getGgoals() {
		return ggoals;
	}

	public void setGgoals(int ggoals) {
		this.ggoals = ggoals;
	}

	public int getGoaldiff() {
		return goaldiff;
	}

	public void setGoaldiff(int goaldiff) {
		this.goaldiff = goaldiff;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}

package de.tha.prog2.task2;

import java.lang.reflect.Constructor;
import java.util.Scanner;

import de.tha.prog2.task1.Game;
import de.tha.prog2.task1.GameDefinition;

public class QuestionGame {

	protected GameDefinition gameDefinition;
	protected Game game;
	protected Player player;
	private HighScore highScore;
	Scanner scanner = new Scanner(System.in);

	private void createGameDefinition(String gameName) {

		Class<?> gameClass;
		try {
			String fullName = "de.tha.prog2.task1." + gameName;
			gameClass = Class.forName(fullName);

			if (GameDefinition.class.isAssignableFrom(gameClass)) {
				Constructor<?> cons1 = gameClass.getConstructor();
				this.gameDefinition = (GameDefinition) cons1.newInstance();
				this.game = this.gameDefinition.getGame(3);
			}
		} catch (Exception e) {
			System.out.println("Spiel konnte nicht geladen werden: " + e.getMessage());
		}
	}

	private void createPlayer(String name) {
		player = new Player(name);
	}

	public void gameLoop() {
		if (this.player == null) {
			System.out.print("Name des Spielers: ");
			this.createPlayer(String.valueOf(scanner.nextLine()));
		}

		System.out.print("Welches Spiel soll geladen werden: ");
		this.createGameDefinition(String.valueOf(scanner.nextLine()));

		if (this.game != null) {

			while (game.hasMoreQuestions()) {
				System.out.println(game.nextQuestion());
				game.recordAnswer(String.valueOf(scanner.nextLine()));
			}

			if (this.highScore == null) {
				this.highScore = new HighScore();
			}

			this.player.recordPoints(game.getPoints());
			this.highScore.recordEntry(this.player);
			System.out.println(this.highScore.toString());
		}

		System.out.print("Mochten Sie nochmal spielen? [ja/nein]: ");
		if (scanner.nextLine().equals("ja")) {
			this.gameLoop();
		} else {
			return;
		}
	}

	public static void main(String[] args) {

		QuestionGame game = new QuestionGame();

		game.gameLoop();
	}

}

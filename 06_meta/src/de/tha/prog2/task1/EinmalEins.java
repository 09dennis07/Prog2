package de.tha.prog2.task1;

import java.util.Random;

public class EinmalEins implements GameDefinition{
	
	public EinmalEins() {}
	
	static class EinmalEinsGame implements Game{
		
		private int questions;
		private int rnd1;
		private int rnd2;
		private int points;
		
		public EinmalEinsGame(int questions) {
			this.questions = questions;
		}

		@Override
		public int getPoints() {
			return points;
		}

		@Override
		public boolean recordAnswer(String answer) {
			if (Integer.parseInt(answer)!= rnd1 * rnd2) {
				return false;
			}
			points++;
			return true;
		}

		@Override
		public String nextQuestion() {
			Random rand = new Random();
			rnd1 = rand.nextInt(1,11);
			rnd2 = rand.nextInt(1,11);
			questions--;
			return "Wie viel ist " + rnd1 + " * " + rnd2 + "?";
		}

		@Override
		public boolean hasMoreQuestions() {
			if (questions != 0) {
				return true;
			}
			return false;
		}
		
	}

	@Override
	public Game getGame(int questions) {
		Game game = new EinmalEinsGame(questions);
		return game;
	}
	
	
	public static void main(String[] args) {
		EinmalEins definition = new EinmalEins();
		Game game = definition.getGame(5);
		System.out.println(game.nextQuestion());
	}

}


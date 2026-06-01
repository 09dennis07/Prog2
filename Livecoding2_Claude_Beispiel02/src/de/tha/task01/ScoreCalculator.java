package de.tha.task01;

public class ScoreCalculator {
	
	public static Calculator getCalculator() {
		
		return new Calculator() {

			@Override
			public double percentage(double scored, double total) {
				double result = (scored / total) * 100.0;
				return Math.round(result*100.0) / 100.0;
			}

			@Override
			public String grade(double percent) {
				if (percent >= 90) {
					return "sehr gut";
				} else if (percent >= 80) {
					return "gut";
				} else if (percent >= 70) {
					return "befriedigend";
				} else if (percent >= 60) {
					return "ausreichend";
				} else {
					return "mangelhaft";
				}
			}
		};
	}
}

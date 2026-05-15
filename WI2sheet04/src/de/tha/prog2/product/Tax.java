package de.tha.prog2.product;

public enum Tax {

	FULL(19.0), REDUCED(7.0);
	
	double percentage;
	
	private Tax(double percentage) {
		this.percentage = percentage;
	}
	
	public double getPriceWithTax(double percentage) {
		return 0;
	}
}

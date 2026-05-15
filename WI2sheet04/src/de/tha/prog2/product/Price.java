package de.tha.prog2.product;

public class Price {
	
	private double netPrice;
	private Tax taxClass;
	
	public Price(double netPrice, Tax taxClass) {
		this.netPrice = netPrice;
		this.taxClass = taxClass;
	}
	
	public double getGrossPrice() {
		return netPrice * (1 + (taxClass.percentage / 100));
	}
	
	public double getNetPrice() {
		return netPrice;
	}

}

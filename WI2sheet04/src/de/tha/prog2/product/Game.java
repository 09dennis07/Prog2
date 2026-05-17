package de.tha.prog2.product;

import de.tha.prog2.shop.Customer;

public class Game extends AbstractProduct implements  Shippable, Downloadable {
	
	private int ageRestriction;
	private static int unitsSold;

	public Game(String title, int ageRestriction, double netPrice, Tax taxClass) {
		super(title, new Price(netPrice, taxClass));
		this.ageRestriction = ageRestriction;
	}

	@Override
	public double getDownloadSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getUnitsSold() {
		return unitsSold;
	}

	@Override
	public void unitSold() {
		unitsSold++;
	}

	@Override
	public void transferTo(Customer c) {
	    c.downloadProduct(this);
	}

	@Override
	public void shipTo(Customer c) {
	    c.receiveProduct(this);
	}

}

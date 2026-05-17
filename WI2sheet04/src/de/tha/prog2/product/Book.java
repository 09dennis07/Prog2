package de.tha.prog2.product;

import de.tha.prog2.shop.Customer;

public class Book extends AbstractProduct implements Shippable, Downloadable{
	
	private String author;
	private static int unitsSold;

	public Book(String author, String title, double netPrice, Tax taxClass) {
		super(title, new Price(netPrice, taxClass));
		this.author = author;
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
	public void transferTo(Customer c) {
	    c.downloadProduct(this);
	}

	@Override
	public void shipTo(Customer c) {
	    c.receiveProduct(this);
	}

}

package de.tha.prog2.product;

public class Book extends AbstractProduct implements Shippable, Downloadable{
	
	private String author;

	public Book(String author, String title, double netPrice, Tax taxClass) {
		super(title, new Price(netPrice, taxClass));
		this.author = author;
	}

	@Override
	public int getUnitsSold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void unitSold() {
		// TODO Auto-generated method stub
		
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

}

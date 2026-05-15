package de.tha.prog2.product;

public class Monitor extends AbstractProduct implements  Shippable{
	
	private String brand;
	private int size;

	public Monitor(String brand, int size, double netPrice, Tax taxClass) {
		super(brand + " " + size + " Zoll", new Price(netPrice, taxClass));
		this.brand = brand;
		this.size = size;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void unitSold() {
		// TODO Auto-generated method stub
		
	}

}

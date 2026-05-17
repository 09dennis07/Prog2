package de.tha.prog2.product;

import de.tha.prog2.shop.Customer;

public class Computer extends AbstractProduct implements  Shippable{
	
	private String category;
    private String brand;
    private static int unitsSold;

    public Computer(String brand, String category, double netPrice, Tax taxClass) {
        super(brand + " " + category + " Computer", new Price(netPrice, taxClass));
        this.brand = brand;
        this.category = category;
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
	public void shipTo(Customer c) {
	    c.receiveProduct(this);
	}

}

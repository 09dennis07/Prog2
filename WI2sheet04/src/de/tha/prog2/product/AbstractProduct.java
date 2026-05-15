package de.tha.prog2.product;

public abstract class AbstractProduct implements Product, Comparable<AbstractProduct>, UnitsSold {
	
	private String name;
	private Price price;

	public AbstractProduct(String name, Price price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Price getPrice() {
		return this.price;
	}
	
	@Override
	public int compareTo(AbstractProduct o) {
	    double meinPreis = this.getPrice().getGrossPrice();
	    double andererPreis = o.getPrice().getGrossPrice();
	    
	    return Double.compare(meinPreis, andererPreis);
	}

	
	public abstract int getUnitsSold();
	public abstract void unitSold();
	
}
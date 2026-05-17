package de.tha.prog2.product;

import de.tha.prog2.shop.Customer;

public interface Shippable {
	
	public double getWidth();
	public double getHeight();
	public double getWeight();
	public double getLength();
	public void shipTo(Customer c);

}

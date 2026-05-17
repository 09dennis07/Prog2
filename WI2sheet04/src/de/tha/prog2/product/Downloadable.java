package de.tha.prog2.product;

import de.tha.prog2.shop.Customer;

public interface Downloadable {
	
	public double getDownloadSize();
	public void transferTo(Customer c);

}

package de.tha.prog2.shop;

import de.tha.prog2.product.Downloadable;
import de.tha.prog2.product.Shippable;

public class FulfillmentCenter {

	public FulfillmentCenter() {
		
	}
	
	public void sentProductsToCustomer(ShoppingCart sc) throws CannotShipException {
		Container container = sc.getProducts();
		Customer customer = sc.getCustomer();
		
		for (int i = 0; i < container.size(); i++) {
			Object element = container.get(i);
			
			if (element instanceof Shippable shippableProduct) {
				shippableProduct.shipTo(customer);
			} else if (element instanceof Downloadable downloadableProduct) {
				downloadableProduct.transferTo(customer);
			} else {
				throw new CannotShipException("Das Produkt an Index " + i + " kann nicht verarbeitet werden.");
			}
			
		}
	}
	


}

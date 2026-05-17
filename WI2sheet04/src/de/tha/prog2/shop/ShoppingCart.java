package de.tha.prog2.shop;

import de.tha.prog2.product.Product;

public class ShoppingCart {
	
	private Customer customer;
	private DoubleLinkedList products;
	
	public ShoppingCart(Customer customer) {
		this.customer = customer;
		this.products = new DoubleLinkedList();
	}
	
	public double getGrossPrice() {
		double totalGrossPrice = 0.0;
		
		for (int i = 0; i < products.size() ; i++) {
			Product currentProduct = (Product) products.get(i);
			totalGrossPrice += currentProduct.getPrice().getGrossPrice();
		}
		return totalGrossPrice;
	}
	
	public Container getProducts() {
		return this.products;
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public Customer getCustomer() {
	    return this.customer;
	} 

}

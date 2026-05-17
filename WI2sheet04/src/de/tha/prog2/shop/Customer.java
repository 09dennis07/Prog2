package de.tha.prog2.shop;

import de.tha.prog2.product.Downloadable;
import de.tha.prog2.product.Shippable;

public class Customer{
	
	private String address;
	private String name;
	private DoubleLinkedList ownedProducts;
	private double money;
	private String emailAddress;
	
	public Customer(String address, String name, double money, String emailAdress) {
		this.address = address;
		this.name = name;
		this.money = money;
		this.emailAddress = emailAddress;
		this.ownedProducts = new DoubleLinkedList();
	}
	
	public void receiveProduct(Shippable s) {
		ownedProducts.add(s);
	}
	
	public void downloadProduct(Downloadable d) {
		ownedProducts.add(d);
	}
	
	public double getAvailableMoney() {
		return money;
	}
	
	public Container getProducts() {
		return this.ownedProducts;
	}
	
	public void pay(double amount) throws NotEnoughMoneyException {
		if (this.money < amount) {
	        throw new NotEnoughMoneyException("Nicht genug Geld vorhanden!");
	    } 
	    else {
	        this.money -= amount;
	    }
	}

}

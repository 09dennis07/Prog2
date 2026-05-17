package de.tha.prog2.shop;

public class Shop{

	
	private FulfillmentCenter fulfillmentCenter;
	private double availableMoney;
	
	public Shop() {
		this.availableMoney = 0;
		this.fulfillmentCenter = new FulfillmentCenter();
	}
	
	public ShoppingCart newShoppingCart(Customer c) {
		ShoppingCart cart = new ShoppingCart(c);
		return cart;
	}
	
	public void buy(ShoppingCart sc) throws NotEnoughMoneyException, CannotShipException {
		double scPrice = sc.getGrossPrice();
		sc.getCustomer().pay(scPrice);
		this.fulfillmentCenter.sentProductsToCustomer(sc);
		this.availableMoney += scPrice;
	}
	
	public double getMoney() {
		return this.availableMoney;
	}
	
	public static void main (String[] args) {
		
	}
	
}

package de.tha.prog2.shop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.tha.prog2.product.Book;
import de.tha.prog2.product.Tax;

class ShopTest {
	
	Customer customer = new Customer("Musterweg 1", "Max", 100.0, "max@mail.de");
	ShoppingCart cart = new ShoppingCart(customer);
    Shop shop = new Shop();
    FulfillmentCenter center = new FulfillmentCenter();
	Book testBook = new Book("Tolkien", "Der Hobbit", 15.0, Tax.REDUCED);

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void instanciateObjects() {

        assertNotNull(customer);
        assertNotNull(shop);
        assertNotNull(cart);
        assertNotNull(center);
	}
	
	@Test
	void addProduct() {
		cart.addProduct(testBook);
		assertEquals(1, cart.getProducts().size());
	}
	
	@Test
	void getProduct() {
		cart.addProduct(testBook);
		assertEquals(testBook, cart.getProducts().get(0));
	}
	
	@Test
	void getGrossPrice() {
		assertEquals(0.0, cart.getGrossPrice());
		cart.addProduct(testBook);
		assertEquals(testBook.getPrice().getGrossPrice(), cart.getGrossPrice());
	}
	
	@Test
	void pay() {
		try {
			customer.pay(99);
		} catch (NotEnoughMoneyException neme) {
			
		}
		assertEquals(1, customer.getAvailableMoney());
	}
	
	@Test
	void testNotEnoughMoneyException() {
		try {
			customer.pay(101);
		} catch (NotEnoughMoneyException neme) {
			
		}
	}
	
	@Test
	void testCannotShipException() {
		try {
			center.sentProductsToCustomer(cart);
		} catch (CannotShipException cse) {
			
		}
	}
	
	@Test
	void receiveProductsShippable() {
		customer.receiveProduct(testBook);
		assertEquals(testBook, customer.getProducts().get(0));
	}
		
	@Test
	void receiveProductsDownloadable() {
		customer.receiveProduct(testBook);
		assertEquals(testBook, customer.getProducts().get(0));
	}
	
	@Test
	void ShoppingCartbuy() {
		cart.addProduct(testBook);
		try {
			shop.buy(cart);
		} catch (NotEnoughMoneyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotShipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(shop.getMoney(), testBook.getPrice().getGrossPrice());
	}
}

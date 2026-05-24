package de.tha.prog2.shop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.tha.prog2.product.AbstractProduct;
import de.tha.prog2.product.Book;
import de.tha.prog2.product.Price;
import de.tha.prog2.product.Product;
import de.tha.prog2.product.Tax;

class ShopTest {
	
	Customer customer;
	ShoppingCart cart;
    Shop shop;
    FulfillmentCenter center;
	Book testBook;

	@BeforeEach
	void setUp() throws Exception {
		customer = new Customer("Musterweg 1", "Max", 100.0, "max@mail.de");
		cart = new ShoppingCart(customer);
		shop = new Shop();
		center = new FulfillmentCenter();
		testBook = new Book("Tolkien", "Der Hobbit", 15.0, Tax.REDUCED);
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
	void testEnoughMoneyException() {
		try {
			customer.pay(99);
		} catch (NotEnoughMoneyException neme) {
			fail("Hätte funktionieren müssen!");
		}
	}
	
	@Test
	void testNotEnoughMoneyException() {
		try {
			customer.pay(101);
			fail("Hätte nicht klappen dürfen!");
		} catch (NotEnoughMoneyException neme) {
		}
	}
	
	@Test
	void testCannotShipException() {
		FulfillmentCenter testFulfill = new FulfillmentCenter();
		ShoppingCart testCart = new ShoppingCart(customer);
		
		Product fehlerhaftesProdukt = new Product() {
			public String getName() { return "Fehler"; }
			public Price getPrice() { return new Price(10.0, Tax.FULL); }
		};
		testCart.addProduct(fehlerhaftesProdukt);

		CannotShipException exception = assertThrows(
				CannotShipException.class,
				() -> {
					testFulfill.sentProductsToCustomer(testCart);
				}
		);
		
	}
	
	@Test
	void receiveProductsShippable() {
		customer.receiveProduct(testBook);
		assertEquals(testBook, customer.getProducts().get(0));
	}

	@Test
	void receiveProductsDownloadable() {
		customer.downloadProduct(testBook);
		assertEquals(testBook, customer.getProducts().get(0));
	}
	
	@Test
	void ShoppingCartbuy() throws NotEnoughMoneyException, CannotShipException {
		cart.addProduct(testBook);
		shop.buy(cart);
		assertEquals(shop.getMoney(), testBook.getPrice().getGrossPrice());
	}
}

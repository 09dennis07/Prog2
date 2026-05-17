package de.tha.prog2.product;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	
    private final Book book1 = new Book("Tolkien", "Herr der Ringe", 28.99, Tax.REDUCED);
    private final Computer computer1 = new Computer("MSI", "Gaming", 999.99, Tax.FULL);
    private final Game game1 = new Game("Modern Warfare 2", 18, 49.99, Tax.FULL);
    private final Monitor monitor1 = new Monitor("AOC", 27, 119.00, Tax.FULL);

    @BeforeEach
    void setUp() throws Exception {   	
    }
    
    @Test
    public void hasNameandPrice() {
    	assertEquals("Herr der Ringe", book1.getName());
    	assertEquals("MSI Gaming Computer", computer1.getName());
    	assertEquals("Modern Warfare 2", game1.getName());
    	assertEquals("AOC 27 Zoll", monitor1.getName());
    	
    	assertEquals(28.99, book1.getPrice().getNetPrice(), 0.001); 
    	assertEquals(999.99, computer1.getPrice().getNetPrice(), 0.001); 
    	assertEquals(49.99, game1.getPrice().getNetPrice(), 0.001); 
    	assertEquals(119.00, monitor1.getPrice().getNetPrice(), 0.001);     	
    }
    
    @Test 
    public void getGrossPrice() {
    	assertEquals(28.99 * 1.07, book1.getPrice().getGrossPrice(), 0.001); 
    	assertEquals(999.99 * 1.19, computer1.getPrice().getGrossPrice(), 0.001); 
    	assertEquals(49.99 * 1.19, game1.getPrice().getGrossPrice(), 0.001); 
    	assertEquals(119.00 * 1.19, monitor1.getPrice().getGrossPrice(), 0.001); 
    }
    
    @Test
    public void comparableByGrossPrice() {
    	Book book2 = new Book("Tolkien", "Herr der Ringe 2", 28.99, Tax.REDUCED);
    	Book book3 = new Book("Tolkien", "Herr der Ringe Extended Holo", 39.99, Tax.REDUCED);
    	assertEquals(0, book1.compareTo(book2));
    	assertTrue(book1.compareTo(book3) < 0);
    	assertTrue(book3.compareTo(book1) > 0);
    }
    
    @Test
    public void unitsSoldTest() {
        int startBooks = book1.getUnitsSold();
        book1.unitSold();
        assertEquals(startBooks + 1, book1.getUnitsSold());
      
        int startComputers = computer1.getUnitsSold();
        computer1.unitSold();
        assertEquals(startComputers + 1, computer1.getUnitsSold());

        int startGames = game1.getUnitsSold();
        game1.unitSold();
        assertEquals(startGames + 1, game1.getUnitsSold());

        int startMonitors = monitor1.getUnitsSold();
        monitor1.unitSold();
        assertEquals(startMonitors + 1, monitor1.getUnitsSold());
    }
    
    @Test
    public void interfaceImplemention() {
    	assertTrue(book1 instanceof Downloadable);
    	assertTrue(book1 instanceof Shippable);
    	assertTrue(game1 instanceof Downloadable);
    	assertTrue(game1 instanceof Shippable);
    	assertTrue(computer1 instanceof Shippable);
    	assertFalse(computer1 instanceof Downloadable);
    	assertTrue(monitor1 instanceof Shippable);
    	assertFalse(monitor1 instanceof Downloadable);
    }
}

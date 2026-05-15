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
}

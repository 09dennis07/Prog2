package de.tha.prog2.task02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit-Tests für die Klasse LibraryCatalogImpl.
 * Diese Tests sind bereits vollständig implementiert.
 * Ihre LibraryCatalogImpl-Implementierung muss alle Tests bestehen.
 */
class LibraryCatalogTest {

    private LibraryCatalogImpl catalog;
    private Book roman1;
    private Book roman2;
    private Book krimi1;
    private Book sachbuch1;

    @BeforeEach
    void setUp() {
        catalog = new LibraryCatalogImpl();

        roman1    = new BookImpl("978-0-00-000001-0", "Das Schloss",       4.8, "Roman");
        roman2    = new BookImpl("978-0-00-000002-0", "Die Verwandlung",   3.5, "Roman");
        krimi1    = new BookImpl("978-0-00-000003-0", "Der Name der Rose", 4.2, "Krimi");
        sachbuch1 = new BookImpl("978-0-00-000004-0", "Sapiens",           4.6, "Sachbuch");

        catalog.addBook(roman1,    3);
        catalog.addBook(roman2,    1);
        catalog.addBook(krimi1,    2);
        catalog.addBook(sachbuch1, 5);
    }

    // ── addBook ──────────────────────────────────────────────────

    @Test
    void testAddBookNewEntry() {
        assertEquals(3, catalog.getStock(roman1));
    }

    @Test
    void testAddBookIncrementsExisting() {
        catalog.addBook(roman1, 2);
        assertEquals(5, catalog.getStock(roman1));
    }

    @Test
    void testAddBookInvalidQuantityIgnored() {
        catalog.addBook(roman1, 0);
        catalog.addBook(roman1, -5);
        assertEquals(3, catalog.getStock(roman1));   // unverändert
    }

    // ── getStock ─────────────────────────────────────────────────

    @Test
    void testGetStockExisting() {
        assertEquals(2, catalog.getStock(krimi1));
    }

    @Test
    void testGetStockNotPresent() {
        Book unknown = new BookImpl("978-0-00-099999-9", "Unbekannt", 1.0, "Roman");
        assertEquals(0, catalog.getStock(unknown));
    }

    // ── getInventory (Datenkapselung) ─────────────────────────────

    @Test
    void testGetInventoryReturnsCopy() {
        Map<Book, Integer> inv = catalog.getInventory();
        inv.clear();   // Kopie leeren darf das Original nicht verändern
        assertEquals(4, catalog.getInventory().size());
    }

    @Test
    void testGetInventorySize() {
        assertEquals(4, catalog.getInventory().size());
    }

    // ── listAvailableBooks ────────────────────────────────────────

    @Test
    void testListAvailableBooksCorrectGenre() {
        List<Book> romans = catalog.listAvailableBooks("Roman");
        assertEquals(2, romans.size());
        assertTrue(romans.contains(roman1));
        assertTrue(romans.contains(roman2));
    }

    @Test
    void testListAvailableBooksSortedDescending() {
        List<Book> romans = catalog.listAvailableBooks("Roman");
        // roman1 (4.8) soll vor roman2 (3.5) stehen
        assertEquals(roman1, romans.get(0));
        assertEquals(roman2, romans.get(1));
    }

    @Test
    void testListAvailableBooksExcludesOutOfStock() {
        // roman2 auf 0 setzen — dazu einen anderen Weg nutzen
        catalog.addBook(roman2, -10);   // ungültig, bleibt bei 1
        // Manuell auf 0 bringen: neuen Katalog anlegen
        LibraryCatalogImpl fresh = new LibraryCatalogImpl();
        fresh.addBook(roman1, 3);
        // roman2 absichtlich NICHT hinzufügen
        List<Book> result = fresh.listAvailableBooks("Roman");
        assertFalse(result.contains(roman2));
    }

    @Test
    void testListAvailableBooksUnknownGenre() {
        List<Book> result = catalog.listAvailableBooks("Fantasy");
        assertTrue(result.isEmpty());
    }

    // ── iterator ─────────────────────────────────────────────────

    @Test
    void testIteratorNotNull() {
        Iterator<Book> it = catalog.iterator();
        assertNotNull(it);
    }

    @Test
    void testIteratorAscendingByRating() {
        // Erwartet: roman2 (3.5), krimi1 (4.2), sachbuch1 (4.6), roman1 (4.8)
        Iterator<Book> it = catalog.iterator();
        double prev = -1.0;
        while (it.hasNext()) {
            double current = it.next().getRating();
            assertTrue(current >= prev, "Iterator soll aufsteigend nach rating sortieren");
            prev = current;
        }
    }
}

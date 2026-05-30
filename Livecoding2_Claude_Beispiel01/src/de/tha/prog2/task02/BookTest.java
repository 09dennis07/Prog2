package de.tha.prog2.task02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit-Tests für die Klasse BookImpl.
 * Diese Tests sind bereits vollständig implementiert.
 * Ihre BookImpl-Implementierung muss alle Tests bestehen.
 */
class BookTest {

    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        // Gleiche ISBN wie book1 → soll als gleich gelten
        book1 = new BookImpl("978-3-16-148410-0", "Der Prozess",      4.5, "Roman");
        book2 = new BookImpl("978-3-16-148410-0", "Der Prozess",      4.5, "Roman");
        book3 = new BookImpl("978-0-7432-7356-5", "1984",             3.8, "Roman");
    }

    @Test
    void testGetters() {
        assertEquals("978-3-16-148410-0", book1.getIsbn());
        assertEquals("Der Prozess",        book1.getTitle());
        assertEquals("Roman",              book1.getGenre());
        assertEquals(4.5,                  book1.getRating(), 0.001);
    }

    @Test
    void testEqualsSymmetric() {
        assertEquals(book1, book2);
        assertEquals(book2, book1);
    }

    @Test
    void testEqualsNotEqual() {
        assertNotEquals(book1, book3);
    }

    @Test
    void testEqualsSelf() {
        assertEquals(book1, book1);
    }

    @Test
    void testEqualsNull() {
        assertNotEquals(null, book1);
    }

    @Test
    void testHashCodeConsistency() {
        // Gleiche ISBN → gleicher hashCode
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    void testHashCodeDifferent() {
        // Unterschiedliche ISBN → in der Regel unterschiedlicher hashCode
        assertNotEquals(book1.hashCode(), book3.hashCode());
    }

    @Test
    void testCompareToHigherRating() {
        // book1 (4.5) > book3 (3.8) → compareTo soll positiv sein
        assertTrue(book1.compareTo(book3) > 0);
    }

    @Test
    void testCompareToLowerRating() {
        // book3 (3.8) < book1 (4.5) → compareTo soll negativ sein
        assertTrue(book3.compareTo(book1) < 0);
    }

    @Test
    void testCompareToEqualRating() {
        // Gleiche Bewertung → compareTo soll 0 sein
        Book same = new BookImpl("978-0-00-000000-0", "Anderes Buch", 4.5, "Krimi");
        assertEquals(0, book1.compareTo(same));
    }

    @Test
    void testToStringContainsTitle() {
        assertTrue(book1.toString().contains("Der Prozess"));
    }

    @Test
    void testToStringContainsIsbn() {
        assertTrue(book1.toString().contains("978-3-16-148410-0"));
    }
}

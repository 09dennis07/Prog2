package de.tha.task02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit-Tests für die Klasse ParticipantImpl.
 * Diese Tests sind bereits vollständig implementiert.
 * Ihre ParticipantImpl muss alle Tests bestehen.
 */
class ParticipantTest {

    private Participant p1;
    private Participant p2;
    private Participant p3;

    @BeforeEach
    void setUp() {
        // p1 und p2 haben dieselbe memberId → sollen als gleich gelten
        p1 = new ParticipantImpl("M001", "Anna Müller",  "PREMIUM",  12);
        p2 = new ParticipantImpl("M001", "Anna Müller",  "PREMIUM",  12);
        p3 = new ParticipantImpl("M002", "Tom Berger",   "STANDARD",  5);
    }

    @Test
    void testGetters() {
        assertEquals("M001",    p1.getMemberId());
        assertEquals("Anna Müller", p1.getName());
        assertEquals("PREMIUM", p1.getMembershipType());
        assertEquals(12,        p1.getVisitCount());
    }

    @Test
    void testEqualsSymmetric() {
        assertEquals(p1, p2);
        assertEquals(p2, p1);
    }

    @Test
    void testEqualsNotEqual() {
        assertNotEquals(p1, p3);
    }

    @Test
    void testEqualsSelf() {
        assertEquals(p1, p1);
    }

    @Test
    void testEqualsNull() {
        assertNotEquals(null, p1);
    }

    @Test
    void testHashCodeConsistency() {
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testHashCodeDifferent() {
        assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    @Test
    void testCompareToHigherVisitCount() {
        // p1 (12 Besuche) > p3 (5 Besuche) → positiv
        assertTrue(p1.compareTo(p3) > 0);
    }

    @Test
    void testCompareToLowerVisitCount() {
        // p3 (5 Besuche) < p1 (12 Besuche) → negativ
        assertTrue(p3.compareTo(p1) < 0);
    }

    @Test
    void testCompareToEqualVisitCount() {
        Participant same = new ParticipantImpl("M999", "Max Mustermann", "VIP", 12);
        assertEquals(0, p1.compareTo(same));
    }

    @Test
    void testToStringContainsName() {
        assertTrue(p1.toString().contains("Anna Müller"));
    }

    @Test
    void testToStringContainsMemberId() {
        assertTrue(p1.toString().contains("M001"));
    }
}

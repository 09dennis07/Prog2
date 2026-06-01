package de.tha.task02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit-Tests für die Klasse EventManagerImpl.
 * Diese Tests sind bereits vollständig implementiert.
 * Ihre EventManagerImpl muss alle Tests bestehen.
 */
class EventManagerTest {

    private EventManagerImpl manager;
    private Participant premium1;
    private Participant premium2;
    private Participant standard1;
    private Participant vip1;

    @BeforeEach
    void setUp() {
        manager   = new EventManagerImpl();
        premium1  = new ParticipantImpl("M001", "Anna Müller",   "PREMIUM",  12);
        premium2  = new ParticipantImpl("M002", "Lisa Weber",    "PREMIUM",   7);
        standard1 = new ParticipantImpl("M003", "Tom Berger",    "STANDARD",  3);
        vip1      = new ParticipantImpl("M004", "Max Mustermann","VIP",      20);

        manager.register(premium1,  2);
        manager.register(premium2,  1);
        manager.register(standard1, 3);
        manager.register(vip1,      1);
    }

    // ── register ─────────────────────────────────────────────────

    @Test
    void testRegisterNewEntry() {
        assertEquals(2, manager.getBookingCount(premium1));
    }

    @Test
    void testRegisterIncrementsExisting() {
        manager.register(premium1, 3);
        assertEquals(5, manager.getBookingCount(premium1));
    }

    @Test
    void testRegisterInvalidCountIgnored() {
        manager.register(premium1, 0);
        manager.register(premium1, -1);
        assertEquals(2, manager.getBookingCount(premium1)); // unverändert
    }

    // ── getBookingCount ───────────────────────────────────────────

    @Test
    void testGetBookingCountExisting() {
        assertEquals(3, manager.getBookingCount(standard1));
    }

    @Test
    void testGetBookingCountNotPresent() {
        Participant unknown = new ParticipantImpl("M999", "Unbekannt", "STANDARD", 0);
        assertEquals(0, manager.getBookingCount(unknown));
    }

    // ── getRegister (Datenkapselung) ──────────────────────────────

    @Test
    void testGetRegisterReturnsCopy() {
        Map<Participant, Integer> reg = manager.getRegister();
        reg.clear(); // Kopie leeren darf das Original nicht verändern
        assertEquals(4, manager.getRegister().size());
    }

    @Test
    void testGetRegisterSize() {
        assertEquals(4, manager.getRegister().size());
    }

    // ── listActiveParticipants ────────────────────────────────────

    @Test
    void testListActiveParticipantsCorrectType() {
        List<Participant> premiums = manager.listActiveParticipants("PREMIUM");
        assertEquals(2, premiums.size());
        assertTrue(premiums.contains(premium1));
        assertTrue(premiums.contains(premium2));
    }

    @Test
    void testListActiveParticipantsSortedDescending() {
        List<Participant> premiums = manager.listActiveParticipants("PREMIUM");
        // premium1 (12 Besuche) soll vor premium2 (7 Besuche) stehen
        assertEquals(premium1, premiums.get(0));
        assertEquals(premium2, premiums.get(1));
    }

    @Test
    void testListActiveParticipantsUnknownType() {
        List<Participant> result = manager.listActiveParticipants("GOLD");
        assertTrue(result.isEmpty());
    }

    // ── iterator ─────────────────────────────────────────────────

    @Test
    void testIteratorNotNull() {
        assertNotNull(manager.iterator());
    }

    @Test
    void testIteratorAscendingByVisitCount() {
        // Erwartet aufsteigend: standard1(3), premium2(7), premium1(12), vip1(20)
        Iterator<Participant> it = manager.iterator();
        int prev = -1;
        while (it.hasNext()) {
            int current = it.next().getVisitCount();
            assertTrue(current >= prev, "Iterator soll aufsteigend nach visitCount sortieren");
            prev = current;
        }
    }
}

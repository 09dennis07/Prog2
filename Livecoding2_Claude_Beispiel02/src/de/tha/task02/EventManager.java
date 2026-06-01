package de.tha.prog2.task02;

import java.util.List;
import java.util.Map;

/**
 * Interface für einen Veranstaltungsmanager.
 *
 * Implementieren Sie dieses Interface in der Klasse EventManagerImpl.
 * Die Klasse soll zusätzlich Iterable&lt;Participant&gt; implementieren, wobei
 * der Iterator die Teilnehmer aufsteigend nach visitCount zurückgibt.
 */
public interface EventManager {

    /**
     * Registriert einen Teilnehmer mit einer Buchungszahl.
     * Falls der Teilnehmer bereits vorhanden ist, wird die Buchungszahl erhöht.
     * Buchungszahlen müssen größer als 0 sein — ungültige Werte werden ignoriert.
     *
     * @param participant der zu registrierende Teilnehmer
     * @param count       die Anzahl der Buchungen (muss > 0 sein)
     */
    void register(Participant participant, int count);

    /**
     * Gibt eine Kopie des internen Registers zurück.
     * Änderungen an der zurückgegebenen Map dürfen den internen Zustand
     * nicht beeinflussen (Datenkapselung).
     *
     * @return eine neue Map mit allen Teilnehmern und ihren Buchungszahlen
     */
    Map<Participant, Integer> getRegister();

    /**
     * Gibt die Buchungszahl des angegebenen Teilnehmers zurück.
     * Falls der Teilnehmer nicht vorhanden ist, wird 0 zurückgegeben.
     *
     * @param participant der gesuchte Teilnehmer
     * @return Buchungszahl, oder 0 wenn nicht vorhanden
     */
    int getBookingCount(Participant participant);

    /**
     * Gibt alle aktiven Teilnehmer des angegebenen Mitgliedschaftstyps zurück.
     * Aktiv bedeutet: Buchungszahl > 0.
     * Die Ergebnisliste ist absteigend nach visitCount sortiert.
     *
     * @param membershipType der gesuchte Mitgliedschaftstyp
     * @return Liste aktiver Teilnehmer des Typs, absteigend nach visitCount
     */
    List<Participant> listActiveParticipants(String membershipType);
}

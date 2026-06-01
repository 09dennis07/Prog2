package de.tha.prog2.task02;

/**
 * Interface für einen Veranstaltungsteilnehmer.
 *
 * Implementieren Sie dieses Interface in der Klasse ParticipantImpl.
 * Zwei Teilnehmer gelten als gleich (equals/hashCode), wenn sie dieselbe memberId haben.
 * Die natürliche Ordnung (compareTo) richtet sich aufsteigend nach visitCount.
 */
public interface Participant extends Comparable<Participant> {

    /**
     * Gibt die eindeutige Mitglieds-ID zurück.
     *
     * @return memberId als String
     */
    String getMemberId();

    /**
     * Gibt den Namen des Teilnehmers zurück.
     *
     * @return Name als String
     */
    String getName();

    /**
     * Gibt den Mitgliedschaftstyp zurück (z.B. "STANDARD", "PREMIUM", "VIP").
     *
     * @return Mitgliedschaftstyp als String
     */
    String getMembershipType();

    /**
     * Gibt die Anzahl bisheriger Besuche zurück.
     *
     * @return Besuchszahl als int
     */
    int getVisitCount();
}

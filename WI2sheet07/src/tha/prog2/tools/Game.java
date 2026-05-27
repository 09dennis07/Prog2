package tha.prog2.tools;

import java.util.Iterator;

/**
 * Die Klasse {@code Game} repräsentiert ein Fußballspiel zwischen zwei Mannschaften
 * an einem bestimmten Spieltag, einschließlich des Spielergebnisses.
 */
public class Game {
    /** Der Spieltag, an dem das Spiel stattgefunden hat. */
    public final int matchDay;

    /** Der Name der Heimmannschaft. */
    public final String homeTeam;

    /** Der Name der Auswärtsmannschaft. */
    public final String awayTeam;

    /** Die Anzahl der von der Heimmannschaft erzielten Tore. */
    public final int homeGoals;

    /** Die Anzahl der von der Auswärtsmannschaft erzielten Tore. */
    public final int awayGoals;

    /**
     * Konstruktor zur Initialisierung eines Spiels mit allen relevanten Informationen.
     *
     * @param matchDay   Der Spieltag
     * @param homeTeam   Die Heimmannschaft
     * @param awayTeam   Die Auswärtsmannschaft
     * @param homeGoals  Tore der Heimmannschaft
     * @param awayGoals  Tore der Auswärtsmannschaft
     */
    public Game(int matchDay, String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        this.matchDay = matchDay;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    /**
     * Gibt eine formatierte Zeichenkette mit Informationen zum Spiel zurück.
     *
     * @return String-Darstellung des Spiels inklusive Spieltag, Teams und Ergebnis.
     */
    public String toString() {
        return String.format("Spieltag: %s - %s vs. %s - Ergebnis: %d : %d",
                this.matchDay, this.homeTeam, this.awayTeam, this.homeGoals, this.awayGoals);
    }
    
}

package de.tha.prog2.task01;

/**
 * Interface für einen Score-Rechner.
 *
 * Implementieren Sie dieses Interface mittels einer anonymen Klasse
 * in der Methode ScoreCalculator.getCalculator().
 */
public interface Calculator {

    /**
     * Berechnet den Prozentsatz der erreichten Punkte.
     * Das Ergebnis wird auf zwei Nachkommastellen gerundet.
     *
     * Beispiele:
     *   percentage(75, 100) → 75.0
     *   percentage(1, 3)    → 33.33
     *   percentage(0, 50)   → 0.0
     *
     * @param scored erreichte Punkte
     * @param total  maximal erreichbare Punkte
     * @return gerundeter Prozentwert (2 Nachkommastellen)
     */
    double percentage(double scored, double total);

    /**
     * Gibt die Note als String zurück, die dem Prozentwert entspricht.
     *
     * Zuordnung:
     *   90 - 100 % → "sehr gut"
     *   80 -  89 % → "gut"
     *   70 -  79 % → "befriedigend"
     *   60 -  69 % → "ausreichend"
     *    0 -  59 % → "mangelhaft"
     *
     * @param percent Prozentwert (0.0 – 100.0)
     * @return Note als String
     */
    String grade(double percent);
}

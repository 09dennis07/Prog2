package de.tha.prog2.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Bonusaufgabe: LoanAnalyzer
 *
 * Liest Ausleihdaten aus einer CSV-Datei ein und gibt die Ergebnisse
 * sortiert auf der Konsole aus.
 */
public class LoanAnalyzer {

    // TODO: Wählen Sie eine geeignete Datenstruktur zum Speichern
    //       der längsten Ausleihe pro Mitglied.
    //       Beispiel: Map<String, LoanRecord>

    /**
     * Bonusaufgabe (a):
     *
     * Liest die Ausleihdaten aus dem InputStream ein.
     * Format pro Zeile: member_name;isbn;title;loan_days;rating
     * Die erste Zeile ist der Header und soll übersprungen werden.
     *
     * Pro Mitglied wird nur der Eintrag mit der längsten Ausleihdauer gespeichert.
     *
     * @param in InputStream der Datei loan_records.txt
     */
    public void readLoanRecords(InputStream in) {
        // TODO: Implementieren Sie das Einlesen mit BufferedReader + InputStreamReader
        // Hinweis: Zeilen aufteilen mit line.split(";")
    }

    /**
     * Bonusaufgabe (b):
     *
     * Gibt die Ergebnisse für jedes Mitglied auf der Konsole aus.
     * Ausgabe absteigend nach Ausleihdauer sortiert.
     *
     * Format:
     * #   Member                  Title                          Days   Rating
     * ___________________________________________________________________
     * 1.  Anna Müller             To Kill a Mockingbird           21    3.8
     *
     * Hinweis: String.format() kann für die Spaltenformatierung verwendet werden.
     */
    public void printResults() {
        // TODO: Implementieren Sie die sortierte Ausgabe
    }
}

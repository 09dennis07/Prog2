package de.tha.prog2.task2;

import java.util.List;
import java.util.Map;

/**
 * Interface für einen Bibliothekskatalog.
 *
 * Implementieren Sie dieses Interface in der Klasse LibraryCatalogImpl.
 * Die Klasse soll zusätzlich Iterable&lt;Book&gt; implementieren, wobei
 * der Iterator die Bücher aufsteigend nach Bewertung (rating) zurückgibt.
 */
public interface LibraryCatalog {

    /**
     * Fügt ein Buch mit einer bestimmten Exemplaranzahl dem Katalog hinzu.
     * Falls das Buch bereits vorhanden ist, wird die bestehende Menge erhöht.
     * Mengen müssen größer als 0 sein — ungültige Mengen werden ignoriert.
     *
     * @param book     das hinzuzufügende Buch
     * @param quantity die Anzahl der Exemplare (muss > 0 sein)
     */
    void addBook(Book book, int quantity);

    /**
     * Gibt eine Kopie des internen Bestands zurück.
     * Änderungen an der zurückgegebenen Map dürfen den internen Zustand
     * nicht beeinflussen (Datenkapselung).
     *
     * @return eine neue Map mit allen Büchern und ihren Exemplarzahlen
     */
    Map<Book, Integer> getInventory();

    /**
     * Gibt die aktuell verfügbare Exemplaranzahl des angegebenen Buches zurück.
     * Falls das Buch nicht im Katalog vorhanden ist, wird 0 zurückgegeben.
     *
     * @param book das gesuchte Buch
     * @return Anzahl der verfügbaren Exemplare, oder 0 wenn nicht vorhanden
     */
    int getStock(Book book);

    /**
     * Gibt alle verfügbaren Bücher eines bestimmten Genres zurück.
     * Es werden nur Bücher mit einem Bestand größer als 0 berücksichtigt.
     * Die Ergebnisliste ist absteigend nach Bewertung (rating) sortiert.
     *
     * @param genre das gesuchte Genre
     * @return Liste aller verfügbaren Bücher des Genres, sortiert nach Bewertung (absteigend)
     */
    List<Book> listAvailableBooks(String genre);
}

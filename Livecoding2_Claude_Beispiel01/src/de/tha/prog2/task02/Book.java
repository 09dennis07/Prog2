package de.tha.prog2.task2;

/**
 * Interface für ein Buch im Bibliothekskatalog.
 *
 * Implementieren Sie dieses Interface in der Klasse BookImpl.
 * Zwei Bücher gelten als gleich (equals/hashCode), wenn sie dieselbe ISBN haben.
 * Die natürliche Ordnung (compareTo) richtet sich nach der Bewertung (rating),
 * wobei höhere Bewertungen als größer gelten.
 */
public interface Book extends Comparable<Book> {

    /**
     * Gibt die ISBN des Buches zurück (eindeutiger Identifikator).
     *
     * @return ISBN als String
     */
    String getIsbn();

    /**
     * Gibt den Titel des Buches zurück.
     *
     * @return Titel als String
     */
    String getTitle();

    /**
     * Gibt das Genre des Buches zurück (z. B. "Roman", "Sachbuch", "Krimi").
     *
     * @return Genre als String
     */
    String getGenre();

    /**
     * Gibt die durchschnittliche Leserbewertung zurück (0.0 bis 5.0).
     *
     * @return Bewertung als double
     */
    double getRating();
}

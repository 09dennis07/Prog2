package übung07;

import java.io.*;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Die Klasse {@code TextProvider} liest den Inhalt der Textdatei
 * und stellt ihn zeilenweise über einen {@link Iterator} zur Verfügung.
 * Optional kann die Anzahl der gelesenen Zeilen begrenzt werden.
 */
public class TextProvider implements Iterable<String> {
    private Stream<String> stream;

    /**
     * Erzeugt einen {@code TextProvider}, der alle Zeilen der Textdatei liest
     * und über einen Iterator verfügbar macht.
     */
    public TextProvider() {
        this(-1);
    }

    /**
     * Erzeugt einen {@code TextProvider}, der die ersten Zeilen der Textdatei liest
     * und über einen Iterator verfügbar macht.
     *
     * @param maxNumLines Anzahl der Zeilen aus der Textdatei, die von der Klasse erzeugt werden.
     *                    Ist der Wert negativ, werden alle Zeilen gelesen.
     */
    public TextProvider(int maxNumLines) {
        InputStream is = TextProvider.class.getClassLoader().getResourceAsStream("bibel.txt");
        BufferedReader bs = new BufferedReader(new InputStreamReader(is));
        this.stream = bs.lines();
        if (maxNumLines >= 0) {
            this.stream = this.stream.limit((long) maxNumLines);
        }
    }

    /**
     * Erzeugt einen Iterator, der über die ersten {@code n} Zeilen Text der Textdatei iteriert.
     * Die Anzahl der Zeilen wird durch den Konstruktor bestimmt.
     *
     * @return ein {@code Iterator<String>} über die gelesenen Textzeilen.
     */
    public Iterator<String> iterator() {
        return this.stream.iterator();
    }
}

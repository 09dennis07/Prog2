package de.tha.prog2.task03;

/**
 * Generisches Functional Interface für einen Filter.
 *
 * Kann mit Lambda-Ausdrücken verwendet werden, z.B.:
 *   Filter&lt;Integer&gt; positiv = x -> x > 0;
 *   Filter&lt;String&gt;  kurz    = s -> s.length() < 5;
 *
 * @param <T> der Typ der zu filternden Elemente
 */
@FunctionalInterface
public interface Filter<T> {

    /**
     * Prüft, ob das übergebene Element den Filter besteht.
     *
     * @param item das zu prüfende Element
     * @return true, wenn das Element den Filter besteht
     */
    boolean test(T item);
}

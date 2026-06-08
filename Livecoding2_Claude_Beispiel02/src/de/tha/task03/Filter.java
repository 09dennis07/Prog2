package de.tha.prog2.task03;

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

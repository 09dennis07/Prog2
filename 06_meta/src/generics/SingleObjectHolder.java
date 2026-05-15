package generics;

public class SingleObjectHolder<E> {
    private E element;
    public void put(E element) {
        this.element = element;
    }
    public E get() {
        return element;
    }
}
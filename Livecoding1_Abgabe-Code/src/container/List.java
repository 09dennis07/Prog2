package de.tha.prog2.container;

public class List extends AbstractContainer {

    ListElement head;
    int size;

    @Override
    public boolean add(Object o) {

        size++;
        if(head == null) {
            head = new ListElement(o);
            return true;
        } 
        
        ListElement current = head;
        while(current.next != null) {
        	current = current.next;
        }
        current.next = new ListElement(o);	        
        
        return true;
    }

    @Override
    public Object get(int i) {
        if(i >= size() || i < 0) throw new IndexOutOfBoundsException();
        ListElement current = head;
        int index = 0;
        while(current != null) {
            if(index == i) {
                return current.value;
            }
            index++;
            current = current.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object o) {
        if(head == null) {
            return false;
        } else {
            ListElement current = head;
            if(current.value.equals(o)) {
                head = current.next;
                size--;
                return true;
            }

            while(current.next != null) {
                if(current.next.value.equals(o)) {
                    current.next = current.next.next;
                    size--;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
}

class ListElement {
    Object value;
    ListElement next;

    public ListElement(Object value) {
        this.value = value;
    }
}


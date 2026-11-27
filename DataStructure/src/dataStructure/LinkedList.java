
package dataStructure;

import java.util.ArrayList;
import java.util.Collection;

public class LinkedList<E> {

    private ArrayList<E> elements = new ArrayList<>();

    public boolean add(E element) {
        return elements.add(element);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return elements.addAll(collection);
    }

    public void clear() {
        elements.clear();
    }

    public boolean contains(E element) {

        return elements.contains(element);
    }

    public E get(int index) {

        return elements.get(index);
    }

    public E peek() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(0);
    }

    public E pop() {
        if (elements.isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return elements.remove(0);
    }

    public boolean remove(E element) {

        return elements.remove(element);
    }

    public boolean isEmpty() {

        return elements.isEmpty();
    }

    public int size() {

        return elements.size();
    }
}

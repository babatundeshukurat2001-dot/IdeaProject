
package dataStructure;

import java.util.HashSet;
import java.util.Set;

public class MySet {

    private Set<Integer> elements;

    public MySet() {
        elements = new HashSet<>();
    }

    public void add(int number) {
        elements.add(number);
    }

    public int size() {
        return elements.size();
    }

    public boolean contains(int number) {
        return elements.contains(number);
    }

    public void remove(int number) {
        elements.remove(number);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}

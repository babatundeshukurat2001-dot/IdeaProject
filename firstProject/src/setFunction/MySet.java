package setFunction;

import java.util.ArrayList;
import java.util.List;

public class MySet {

    private final List<Integer> elements = new ArrayList<>();

    public void add(int element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    public boolean remove(int element) {
        return elements.remove((Integer) element);
    }

    public void removeAll(MySet other) {
        elements.removeAll(other.elements);
    }

    public boolean contains(int element) {
        return elements.contains(element);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean isNotEmpty() {
        return false;
    }
}

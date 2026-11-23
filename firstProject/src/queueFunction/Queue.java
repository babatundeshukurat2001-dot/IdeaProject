package queueFunction;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private final List<Integer> items = new ArrayList<>();

    public void enqueue(int i) {
        items.add(i);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int dequeue() {
        if (items.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return items.remove(0);
    }

    public int peek() {
        if (items.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return items.get(0);
    }

    public int size() {
        return items.size();
    }
}
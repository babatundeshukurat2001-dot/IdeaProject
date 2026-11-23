package dataStructure;

import java.util.ArrayList;

public class MyQueue {

    private ArrayList<String> elements = new ArrayList<>();

    public void enqueue(String element) {
        elements.add(element);
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return elements.remove(0);
    }


    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return elements.get(0);
    }


    public boolean isEmpty() {
        return elements.isEmpty();
    }


    public int size() {
        return elements.size();
    }
}

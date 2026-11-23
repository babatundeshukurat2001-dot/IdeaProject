package dataStructure;

public class MyStack {
    private String[] elements;
    private int topPosition;
    private int maximumSize;

    public MyStack() {
        maximumSize = 10;
        elements = new String[maximumSize];
        topPosition = -1;
    }

    public MyStack(int size) {
        maximumSize = size;
        elements = new String[size];
        topPosition = -1;
    }

    public void push(String element) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }

        topPosition++;
        elements[topPosition] = element;
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        String removedElement = elements[topPosition];
        elements[topPosition] = null;
        topPosition--;

        return removedElement;
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return elements[topPosition];
    }

    public boolean isEmpty() {
        return topPosition == -1;
    }

    public boolean isFull() {
        return topPosition == maximumSize - 1;
    }

    public int size() {
        return topPosition + 1;
    }
}

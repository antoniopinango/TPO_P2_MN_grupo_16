package ejercicio_2.model;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> elements;

    public Stack() {
        elements = new LinkedList<>();
    }

    public void push(T item) {
        elements.addLast(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.getLast();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

}

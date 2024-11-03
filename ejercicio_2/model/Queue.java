package ejercicio_2.model;


import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> elements;

    public Queue() {
        elements = new LinkedList<>();
    }

    public void enqueue(T item) {
        elements.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements.removeFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public LinkedList<T> getElements() {
        return elements;
    }
}

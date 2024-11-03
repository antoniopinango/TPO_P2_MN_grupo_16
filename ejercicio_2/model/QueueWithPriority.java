package ejercicio_2.model;

import java.util.PriorityQueue;

class QueueWithPriority<T> {
    private PriorityQueue<T> elements;

    public QueueWithPriority() {
        elements = new PriorityQueue<>();
    }

    public void enqueue(T item) {
        elements.offer(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements.poll();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
}

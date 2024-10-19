package src.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueOfStacks {
    private Queue<Stack<Integer>> queue;

    public QueueOfStacks() {
        queue = new LinkedList<>();
    }

    public void enqueue(Stack<Integer> stack) {
        queue.offer(stack);
    }

    public Stack<Integer> dequeue() {
        if (!queue.isEmpty()) {
            return queue.poll();
        }
        throw new IllegalStateException("Dequeue from empty queue");
    }

    public Stack<Integer> getStack(int index) {
        if (index < 0 || index >= queue.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (Stack<Integer>) ((LinkedList<Stack<Integer>>) queue).get(index);
    }

    public int size() {
        return queue.size();
    }
}

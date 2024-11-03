package ejercicio_3.model;

import ejercicio_2.model.Queue;
import java.util.LinkedList;

public class QueueOfQueue<T> {

    private LinkedList<Queue<T>> queues;

    public QueueOfQueue() {
        queues = new LinkedList<>();
    }

    public void addQueue(Queue<T> queue) {
        queues.add(queue);
    }

    public QueueOfQueue<T> concatenate(QueueOfQueue<T>... queueOfQueues) {
        QueueOfQueue<T> result = new QueueOfQueue<>();

        for (QueueOfQueue<T> qoq : queueOfQueues) {
            for (Queue<T> queue : qoq.queues) {
                result.addQueue(queue);
            }
        }

        return result;
    }

    public Queue<T> flat() {
        Queue<T> flatQueue = new Queue<T>();

        for (Queue<T> queue : queues) {
            for (T element : queue.getElements()) {
                flatQueue.enqueue(element);
            }
        }

        return flatQueue;
    }

    public void reverseWithDepth() {
        // Invertir la QueueOfQueue
        LinkedList<Queue<T>> reversedQueues = new LinkedList<>();
        while (!queues.isEmpty()) {
            reversedQueues.add(queues.removeLast());
        }
        queues = reversedQueues;

        // Invertir cada Queue dentro de esta
        for (Queue<T> queue : queues) {
            LinkedList<T> reversedQueueElements = new LinkedList<>();
            while (!queue.isEmpty()) {
                reversedQueueElements.add(queue.dequeue());
            }
            for (T element : reversedQueueElements) {
                queue.enqueue(element);
            }
        }
    }

    public LinkedList<Queue<T>> getQueues() {
        return queues;
    }
}

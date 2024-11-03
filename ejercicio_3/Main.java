package ejercicio_3;

import ejercicio_2.model.Queue;
import ejercicio_3.model.QueueOfQueue;

public class Main {
        public static void main(String[] args) {
            Queue<Integer> queue1 = new Queue<>();
            queue1.enqueue(1);
            queue1.enqueue(2);
            queue1.enqueue(3);

            Queue<Integer> queue2 = new Queue<>();
            queue2.enqueue(4);
            queue2.enqueue(5);
            queue2.enqueue(6);

            Queue<Integer> queue3 = new Queue<>();
            queue3.enqueue(7);
            queue3.enqueue(8);
            queue3.enqueue(9);

            QueueOfQueue<Integer> qoq1 = new QueueOfQueue<>();
            qoq1.addQueue(queue1);
            qoq1.addQueue(queue2);
            qoq1.addQueue(queue3);

            // Concatenate
            QueueOfQueue<Integer> concatenated = qoq1.concatenate(qoq1);

            System.out.println("------------------------Concatenated:------------------------");
            for (Queue<Integer> queue : concatenated.getQueues()) {
                System.out.println(queue.getElements());
            }
            // Queue convertido en con 3 queues
            Queue<Integer> flatQueue = qoq1.flat();

            System.out.println("------------------------Convertido en un solo Array:------------------------");
            for (Integer intt : flatQueue.getElements() ){
                System.out.print(intt + " -> ");
            }

            // ReverseWithDepth
            qoq1.reverseWithDepth();

            System.out.println("\n------------------------QueueOfQueue Invertiddo:------------------------");
            for (Queue<Integer> queue : qoq1.getQueues()) {
                System.out.println(queue.getElements());
            }
        }
}

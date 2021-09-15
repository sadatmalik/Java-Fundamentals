package labs_examples.datastructures.queue.labs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *      Demonstrate your mastery of Java's (sun's) built-in Queue class (as seen in the import statement
 *      above) by completing the following:
 *
 *      1) instantiate a new Queue
 *      2) demonstrate the use of EVERY method in the Queue class - there are 7
 */

public class Exercise_01 {

    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue();

        // I only see 6 methods in the Queue interface ?

        // 1. add
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        // 2. offer
        q.offer(7); // offer will not insert the element if there is no space in the queue, that won't be an issue here
        q.offer(8);
        q.offer(9);
        q.offer(10);
        q.offer(11);

        // 3. remove
        System.out.println(q.remove()); // FIFO, = 1 - exception if empty

        // 4. poll
        System.out.println(q.poll()); // FIFO, = 2 - null if empty

        // 5. element
        System.out.println(q.element()); // FIFO, = 3 - but will leave it on the queue, exception if empty

        // 6. peek
        System.out.println(q.peek()); // FIFO, = 3 - leave it on the queue, null if empty

    }
}
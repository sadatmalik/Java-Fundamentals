package labs_examples.datastructures.queue.labs;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *      Queues - Exercise_02
 *
 *      Write a new custom (Generic) Queue class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Queue class must also do the following:
 *
 *      done - 1) throw a custom exception when trying to pop  an element from an empty Queue
 *      done - 2) resize the Queue (the underlying array) to be twice the size when the Queue is more than 3/4 full
 *      done - 3) resize the Queue (the underlying array) to be half the size when the Queue is more than 1/4 empty
 *      done - 4) contain the methods peekFirst() and peekLast()
 *      done - 5) contain a size() method
 *      done - 6) contain a method to print out the data of all elements in the Queue
 *
 */

public class Exercise_02 {
    public static void main(String[] args) {
        testQueueOnArray();
    }

    private static void testQueueOnArray() {
        QueueOnArray<Integer> q = new QueueOnArray();

        // push
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);

        // peek
        System.out.println("Peek = " + q.peek());
        System.out.println("Peek = " + q.peek());

        // pop
        try {
            System.out.println("Pop = " + q.pop());
            System.out.println("Pop = " + q.pop());
        } catch (NoSuchItemException e) {
            e.printStackTrace();
        }

        // resize - up
        q.push(4);
        q.push(5);
        q.push(6);
        q.push(7);

        // resize - down
        try {
            System.out.println(q.pop());
            System.out.println(q.pop());
        } catch (NoSuchItemException e) {
            e.printStackTrace();
        }

        // peekFist
        System.out.println("Peek First = " + q.peekFirst()); // 5

        // peekLast
        System.out.println("Peek Last = " + q.peekLast()); // 1

        // size
        System.out.println("Size = " + q.size()); // 5

        // toString
        System.out.println("To String = " + q);

        // uncomment to throw NoSuchItemException
        try {
            while (q.size() > 0) {
                System.out.println(q.pop());
            }
            // System.out.println(q.pop());

        } catch (NoSuchItemException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}

class QueueOnArray<T> {

    private T[] data;
    private int pointer;

    private int lowerLimit;
    private int upperLimit;

    public QueueOnArray() {
        data = (T[]) new Object[10];
        lowerLimit = 0;
        upperLimit = 7;
    }

    public void push(T item) {
        data[pointer] = item;
        pointer++;
        if (pointer >= upperLimit) {
            resize(data.length * 2);
        }
    }

    public T pop() throws NoSuchItemException {
        if (pointer == 0) {
            throw new NoSuchItemException("Queue is empty");
        }
        T item = data[pointer-1];
        pointer--;
        if (lowerLimit != 0 && pointer <= lowerLimit) {
            resize(data.length / 2);
        }
        return item;
    }

    public T peek() {
        if (pointer == 0) {
            return null;
        }
        return data[pointer-1];
    }

    public T peekFirst() {
        return peek();
    }

    public T peekLast() {
        if (pointer == 0) {
            return null;
        }
        return data[0];
    }

    public int size() {
        return pointer;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < pointer; i++) {
            newArray[i] = data[i];
        }
        upperLimit = newSize * 3 / 4;
        lowerLimit = newSize / 4;

        System.out.println("Resize array = " + newSize +
                ", Upper limit = " + upperLimit +
                ", Lower limit = " + lowerLimit);

        data = newArray;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < pointer-1; i++) {
            sb.append(data[i] + ", ");
        }
        sb.append(data[pointer-1]);

        return "QueueOnArray{" +
                "data=" + sb +
                ", pointer=" + pointer +
                ", lowerLimit=" + lowerLimit +
                ", upperLimit=" + upperLimit +
                '}';
    }
}

class NoSuchItemException extends Exception {
    private String msg;

    public NoSuchItemException(String message) {
        this.msg = message;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
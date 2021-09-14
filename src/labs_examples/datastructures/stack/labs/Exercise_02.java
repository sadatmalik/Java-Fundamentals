package labs_examples.datastructures.stack.labs;

import java.util.Arrays;

/**
 *      Stacks - Exercise_02
 *
 *      Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Stack class must also do the following: (Ryan Take 2)
 *
 *      done - 1) throw a custom exception when trying to pop an element from an empty Stack
 *      done - 2) resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full
 *      done - 3) resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty
 *      done - 4) contain the methods peekFirst() and peekLast()
 *      done - 5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Stack
 *
 *      TIP: To initialize an new array of a Generic type you can use this:
 *           T[] data = (T[]) new Object[10];
 */

class Stack<T> {

    private T[] data;
    private int pointer = 0;

    private int upperLimit;
    private int lowerLimit;

    public Stack() {
        data = (T[]) new Object[10];
        upperLimit = 7;
        lowerLimit = 0;
    }

    public void push(T item) {
        data[pointer] = item;
        pointer++;
        if (pointer >= upperLimit) {
            resize(data.length * 2);
        }
    }

    public T peek() {
        return data[pointer-1];
    }

    public T peekFirst() {
        return peek();
    }

    public T peekLast() {
        return data[0];
    }

    public T pop() throws StackUnderFlowException{
        if (pointer == 0) {
            throw new StackUnderFlowException("Stack empty");
        }
        T item = data[pointer-1];
        data[pointer-1] = null;
        pointer--;
        if (lowerLimit != 0 && pointer <= lowerLimit) {
            resize(data.length / 2);
        }
        return item;
    }

    public boolean empty() {
        return pointer == 0;
    }

    public int search(T item) {
        int depth = 0;
        for (int i = pointer; i >= 0; i--) {
            if (data[i] == item) {
                return depth;
            }
            depth++;
        }
        return depth;
    }

    public int size() {
        return pointer;
    }

    private void resize(int size) {
        T[] newArray = (T[]) new Object[size];
        for (int i = 0; i <= pointer; i++) {
            newArray[i] = data[i];
        }
        data = newArray;

        upperLimit = data.length * 3 / 4;
        lowerLimit = data.length / 4;

        System.out.println("Resized stack = " + data.length +
                ", upper limit = " + upperLimit + ", lower limit = " + lowerLimit);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "data=" + Arrays.toString(data) +
                ", pointer=" + pointer +
                ", upperLimit=" + upperLimit +
                ", lowerLimit=" + lowerLimit +
                '}';
    }

}

class StackUnderFlowException extends Exception {

    String msg;

    public StackUnderFlowException(String message) {
        this.msg = message;
    }

    @Override
    public String getMessage() {
        return msg;
    }

}

public class Exercise_02 {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();

        // push
        myStack.push("four");
        myStack.push("three");
        myStack.push("two");
        myStack.push("one");

        // peek
        System.out.println(myStack.peek());

        // pop
        try {
            System.out.println(myStack.pop());
        } catch (StackUnderFlowException sufe) {
            sufe.printStackTrace();
        }

        // search
        System.out.println("Depth of \'four\' = " + myStack.search("four"));

        // empty
        while (!myStack.empty()) {
            try {
                System.out.println(myStack.pop());
            } catch (StackUnderFlowException sufe) {
                sufe.printStackTrace();
            }
        }

        // uncomment to throw StackUnderflowException
//        try {
//            myStack.pop();
//        } catch (StackUnderFlowException sufe) {
//            System.out.println("Stack is empty -- cannot pop()");
//            sufe.printStackTrace();
//        }

        // resize - up
        for (int i = 0; i < 10; i++) {
            myStack.push(String.valueOf(i));
        }

        try {
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());

        } catch (StackUnderFlowException sufe) {
            sufe.printStackTrace();
        }

        // peekFirst / peekLast
        System.out.println("First = " + myStack.peekFirst());
        System.out.println("Last = " + myStack.peekLast());

        // size
        System.out.println("Size = " + myStack.size());

        // toString
        System.out.println(myStack);
    }

}
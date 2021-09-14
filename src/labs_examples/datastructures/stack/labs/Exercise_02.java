package labs_examples.datastructures.stack.labs;

/**
 *      Stacks - Exercise_02
 *
 *      Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Stack class must also do the following: (Ryan Take 2)
 *
 *      done - 1) throw a custom exception when trying to pop an element from an empty Stack
 *      2) resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full
 *      3) resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Stack
 *
 *      TIP: To initialize an new array of a Generic type you can use this:
 *           T[] data = (T[]) new Object[10];
 */

class Stack<T> {

    private T[] data;
    private int pointer = 0;

    public Stack() {
        data = (T[]) new Object[10];
    }

    public void push(T item) {
        data[pointer] = item;
        pointer++;
    }

    public T peek() {
        return data[pointer-1];
    }

    public T pop() throws StackUnderFlowException{
        if (pointer == 0) {
            throw new StackUnderFlowException("Stack empty");
        }
        T item = data[pointer-1];
        data[pointer-1] = null;
        pointer--;
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
    }

}
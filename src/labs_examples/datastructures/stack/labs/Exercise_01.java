package labs_examples.datastructures.stack.labs;

import java.util.Stack;

/**
 *      Demonstrate your mastery of Java's built-in Stack class by completing the following:
 *
 *      1) instantiate a new Stack
 *      2) demonstrate the use of EVERY method in the Stack class - there are 5
 */

public class Exercise_01 {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // push()
        stack.push("here");
        stack.push("once");
        stack.push("was");
        stack.push("Sadat");

        // peek()
        System.out.println(stack.peek());

        // pop()
        System.out.println(stack.pop());

        // search()
        System.out.println("Depth of \'here\' = " + stack.search("here"));

        // empty()
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
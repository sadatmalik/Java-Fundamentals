package labs_examples.exception_handling.labs;

import java.util.Arrays;

/**
 * Exception Handling Exercise 5:
 *
 *      Demonstrate how to throw an exception.
 *
 */

class Example {

    public static void main(String[] args) {

        try {
            System.out.println(divide(6, 0));
        } catch (ArithmeticException aex) {
            aex.printStackTrace();
        }

    }

    public static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return a / b;
    }

}
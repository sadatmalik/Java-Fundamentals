package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 6:
 *
 *      Demonstrate throwing an exception in one method and catching it in another method.
 *
 */

class ThrowDemo {
    public static void main(String[] args) {

        try {
            divide(6, 2);

            divide(6, 0);

        } catch (ArithmeticException aex) {
            aex.printStackTrace();
        }
    }

    public static void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        System.out.println(a / b);
    }
}
package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 3:
 *
 *      Demonstrate a try/catch/finally block.
 *
 */

class TryCatchFinallyDemo {

    public static void main(String[] args) {

        // exception case
        System.out.println(divide(4, 0));

        // no exception case
        System.out.println(divide(4,2));
    }

    public static int divide(int a, int b) {

        int x = -1;
        try {
            x = a / b;
        } catch (ArithmeticException aex) {
            aex.printStackTrace();
        } finally {
            System.out.println("divide(" + a + ", " + b + ")");
        }
        return x;
    }
}
package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 1:
 *
 *      1) Demonstrate a try/catch.
 *
 */

class TryCatchDemo {

    public static void main(String[] args) {
        try {
            System.out.println(division(6, 3));
            System.out.println(division(3, 0));
        } catch (ArithmeticException ae) {
            System.out.println("Caught division by Zero attempt");
        }
    }

    public static int division(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a/b;
    }


}
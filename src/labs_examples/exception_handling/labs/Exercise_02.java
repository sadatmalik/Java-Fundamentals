package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 2:
 *
 *      Demonstrate a try/catch with multiple catch statements.
 *
 */

class TryCatchMultipleDemo {

    public static void main(String[] args) {
        // null pointer
        System.out.println(divide(null));

        // index out of bounds
        System.out.println(divide(new int[] {1}));

        // division by zero
        System.out.println(divide(new int[] {3, 0}));

        // ok
        System.out.println(divide(new int[] {6, 3}));
    }

    public static int divide(int[] nums) {

        int x = 0;

        try {
            x = nums[0] / nums[1];
        } catch (ArrayIndexOutOfBoundsException aiex) {
            aiex.printStackTrace();
        } catch (ArithmeticException aex) {
            aex.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return x;
    }

}



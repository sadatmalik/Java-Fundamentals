package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 4:
 *
 *      Demonstrate a nested try/catch.
 *
 */
class NestedTryCatch {


    public static void main(String[] args) {

        int[] num = new int[] {4, 5, 6};

        try {

            System.out.println("First try");
            int x = num[3];

        } catch (ArrayIndexOutOfBoundsException aex) {

            aex.printStackTrace();

            try {
                // try again
                System.out.println("Second try");
                int x = num[4];

            } catch (ArrayIndexOutOfBoundsException aex2) {

                // exit
                aex2.printStackTrace();
            }
        }
    }
}
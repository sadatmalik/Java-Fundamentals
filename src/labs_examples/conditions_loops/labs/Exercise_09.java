package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 9: break
 *
 *      Demonstrate the use of the "break" statement to exit a loop.
 *
 */

public class Exercise_09 {

    public static void main(String[] args) {
        int count = 0;
        while(true) {
            System.out.println(count);
            if (count == 10) {
                break;
            }
            count++;

        }
    }

}

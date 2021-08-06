package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 8: do-while loop
 *
 *      Use a "do-while" loop print out every third number counting backwards from 1000 to 1.
 *
 */

public class Exercise_08 {

    public static void main(String[] args) {
        int i = 1000;
        int count = 1;
        do {
            if (count == 1 || count == 2) {
                count++;
                i--;
                continue;
            }

            System.out.println(i);
            count = 1;
            i--;

        } while (i > 0);
    }
}

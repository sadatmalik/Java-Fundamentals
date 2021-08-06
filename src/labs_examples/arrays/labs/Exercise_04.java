package labs_examples.arrays.labs;

/**
 *  Irregular Arrays
 *
 *      Create and populate a 2 dimensional irregular array of size and contents of your choosing. Using a nested
 *      "for-each" loop, iterate and print out each element of the array.
 *
 */

public class Exercise_04 {

    public static void main(String[] args) {

        int[][] multi = {
                {2, 3, 4},
                {5, 6},
                {7, 8, 9, 10},
                {11, 12, 13},
                {15}
        };

        for (int[] inner : multi) {
            for (int i : inner) {
                System.out.print(i + " | ");
            }
            System.out.println();
        }
    }

}

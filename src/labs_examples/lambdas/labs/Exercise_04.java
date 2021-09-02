package labs_examples.lambdas.labs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Lambdas Exercise 4:
 *
 *      Stream API Labs
 *
 *      1) Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)
 *      2) Demonstrate the use of the sum function to determine the range of a set of numbers.
 *      3) Demonstrate the use of the map() function to alter each int in a List of Integers, then use the sum function
 *          to get the sum of the modified list
 *      4) Demontrate the filter function by filtering out all Integers that are less than 10 - then use the average
 *          function to average the remaining numbers, assign this result to an int variable.
 *      5) Demonstrate the reduce() function to determine the sum of a list of Integers
 *      6) Demontsrate how to Stream a text file and print out each line
 *      7) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          the print out the element at the 1 index for each array.
 *      8) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          the print out the sum of all elements at index 2.
 *      9) Demonstrate the anyMatch() function.
 *      10) Demonstrate the allMatch() function.
 *      11) Demonstrate the collect() terminal operation to store resulting values into a List
 *      
 */

class Example {
    public static void main(String[] args) {

        // 1) Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)
        System.out.println("\n---------- Example 1 ------------");
        IntStream.range(1, 16).forEach(System.out::println);

        // 2) Demonstrate the use of the sum function to determine the range of a set of numbers.
        System.out.println("\n---------- Example 2 ------------");
        System.out.println(IntStream.range(1, 5).sum());

        // 3) Demonstrate the use of the map() function to alter each int in a List of Integers, then use the sum function
        // to get the sum of the modified list
        System.out.println("\n---------- Example 3 ------------");
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        int sumOfSquares = list.stream().map((x) -> x * x).reduce(0, (a, b) -> a +b);
        System.out.println(sumOfSquares);

        // 4) Demontrate the filter function by filtering out all Integers that are less than 10 - then use the average
        // function to average the remaining numbers, assign this result to an int variable.
        System.out.println("\n---------- Example 4 ------------");
        int y = (int) IntStream
                .of(11, 21, 3, 4, 15)
                .filter((x) -> x > 9)
                .average()
                .getAsDouble();
        System.out.println(y);

        // 5) Demonstrate the reduce() function to determine the sum of a list of Integers
        System.out.println("\n---------- Example 5 ------------");
        List<Integer> ints = new ArrayList<>(List.of(1, 2, 3,4));
        int sum = ints.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

//        6) Demontsrate how to Stream a text file and print out each line
//        7) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
//           the print out the element at the 1 index for each array.
//        8) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
//           the print out the sum of all elements at index 2.
//        9) Demonstrate the anyMatch() function.
//        10) Demonstrate the allMatch() function.
//        11) Demonstrate the collect() terminal operation to store resulting values into a List


    }
    
}
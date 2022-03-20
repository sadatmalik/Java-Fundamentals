package labs_examples.sorting_algorithms.labs;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * O(n^2) time complexity - The Bubble Sort is the worst, most inefficient data sorting
 * method.
 *
 * Relatively easy to understand and visualize.
 *
 * @author sm@creativefusion.net
 */
public class BubbleSort {

    private static void bubbleSort(int[] nums) {

        int n = nums.length;

        // first pass all the way through, next pass, 1 less; next pass 1 less,
        // and so on
        for (int i = n-1; i > 0; i--) {

            for (int x = 0; x < i; x++) {

                // compare current and next and swap if out of place
                if (nums[x] > nums[x+1]) {
                    int tmp = nums[x];
                    nums[x] = nums[x+1];
                    nums[x+1] = tmp;
                }
            }
        }
    }

    private static void bubbleSortStream(int[] nums) {

        int n = nums.length;

        IntStream.range(n-1, 0) // from last index to first index + 1
                .flatMap(i -> IntStream.range(0, i))
                .forEach(x -> {
                    int tmp = nums[x];
                    nums[x] = nums[x+1];
                    nums[x+1] = tmp;
                });
    }

    public static void main(String[] args) {
        int[] array = {3,4,2,1,7,5,4,6,8,9,3,4,1};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = {3,4,2,1,7,5,4,6,8,9,3,4,1};
        bubbleSortStream(array2);
        System.out.println(Arrays.toString(array));
    }
}

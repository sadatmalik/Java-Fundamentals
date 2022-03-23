package labs_examples.sorting_algorithms.labs;

import java.util.Arrays;

/**
 * The Insertion Sort is another relatively simple, quadratic (O(n2)) sorting
 * algorithm.
 *
 * Generally speaking, any simple quadratic (O(n2)) sorting algorithm such as
 * Bubble Sort, Selection Sort or Insertion Sort will work just fine for small
 * data sets.
 *
 * You only need the big fancy sorts like Merge Sort, Heap Sort and Quick Sort
 * when you're dealing with much larger data sets.
 *
 * The Insertion Sort works much the same way you do when you sort a
 * collection of playing cards in your hand. You start by placing the smallest
 * card to the left, then you insert cards in ascending order to the right (or
 * vice versa).
 *
 * @author sm@creativefusion.net
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = {1,8,4,6,3};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1,8,4,6,3};
        recursiveInsertionSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] >= nums[i-1])
                continue;

            int tmp = nums[i];

            for (int j = i; j >= 1; j--) {

                nums[j] = nums[j-1];

                if (j == 1) {
                    nums[0] = tmp;
                    break;
                } else if (tmp >= nums[j-2]) {
                    nums[j - 1] = tmp;
                    break;
                }
            }
        }
    }

    public static void recursiveInsertionSort(int[] nums, int n) {

        if (n <= 1)
            return;

        recursiveInsertionSort(nums, n-1);

        int tmp = nums[n-1];
        int j = n-2;

        while(j >= 0 && nums[j] > tmp) {
            nums[j+1] = nums[j];
            j--;
        }
        nums[j+1] = tmp;
    }

}

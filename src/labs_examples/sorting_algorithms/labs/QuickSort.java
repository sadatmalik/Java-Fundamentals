package labs_examples.sorting_algorithms.labs;

import java.util.Arrays;

/**
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element
 * as a pivot and partitions the given array around the chosen pivot. There are many
 * versions of quickSort that pick the pivot in different ways:
 *
 * 1. Always pick the first element as pivot.
 * 2. Always pick the last element as pivot.
 * 3. Pick a random element as the pivot.
 * 4. Pick the median as the pivot. (implemented below)
 *
 * The key method in quickSort is partition().
 *
 * The aim of partitions is: given an array and an element x of the array as the
 * pivot value, ensure that all elements smaller than x are placed before all elements
 * greater than x.
 *
 * Partition achieves this by traversing the array from either end, comparing values
 * as it goes. It tracks and returns the ending array position - which will be
 * the index value at which the array is divided into sub-arrays for the each
 * consecutive cycle.
 *
 * This is clearer to understand, I think, by seeing the code.
 *
 * Quicksort yields a time complexity of O(n log n).
 *
 * @author sm@creativefusion.net
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {15, 3, 2, 1, 9, 5, 7, 8, 6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    static void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int pivot = nums[(left + right) / 2]; //median
        int index = partition(nums, left, right, pivot); //return index to split on
        quickSort(nums, left, index - 1);
        quickSort(nums, index, right);
    }

    static int partition(int[] nums, int left, int right, int pivot) {
        while (left <= right) { // important - test for left less than or equal to right
            while(nums[left] < pivot) { // important - test for less than
                left++;
            }

            while(nums[right] > pivot) { // important - test for greater than
                right--;
            }

            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}

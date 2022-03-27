package labs_examples.sorting_algorithms.labs;

import java.util.Arrays;

/**
 * The Merge sort is a divide and conquer algorithm that was invented by John
 * von Neumann in 1945. A detailed description and analysis of bottom-up mergesort
 * appeared in a report by Goldstine and von Neumann as early as 1948.
 *
 * Conceptually, a merge sort works as follows:
 *
 * 1. Divide the unsorted list into n sub-lists, each containing one element (a list
 * of one element is considered sorted).
 *
 * 2. Repeatedly merge sub-lists to produce new sorted sub-lists until there is only
 * one sub-list remaining. This will be the sorted list.
 *
 * Time complexity of Merge Sort is  θ(nLogn) in all 3 cases (worst, average and best)
 * as merge sort always divides the array into two halves and takes linear time to
 * merge two halves.
 *
 * Auxiliary Space: O(n)
 * Algorithmic Paradigm: Divide and Conquer
 * Sorting In Place: No in a typical implementation
 * Stable: Yes
 *
 * @author sm@creativefusion.net
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {38,27,43,39,82,10};
        System.out.println("Unsorted nums = " + Arrays.toString(nums) + "\n");

        mergeSort(nums, 0, nums.length-1);
        System.out.println("Sorted nums = " + Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        // split the array and recursively calls itself
        int middle = (left + right) / 2;

        mergeSort(nums, left, middle);
        mergeSort(nums, middle+1, right);

        // merge the result
        merge(nums, left, middle, right);
    }

    private static void merge(int[] nums, int left, int middle, int right) {

        int[] leftNums = Arrays.copyOfRange(nums, left, middle+1);
        int[] rightNums = Arrays.copyOfRange(nums, middle+1, right+1);

        System.out.println("Left = " + Arrays.toString(leftNums));
        System.out.println("Right = " + Arrays.toString(rightNums));

        // initial index of left and right arrays
        int i = 0, j = 0;

        // index of merged subarray
        int k = left;
        while (i < leftNums.length && j < rightNums.length) {

            if (leftNums[i] <= rightNums[j]) {
                nums[k] = leftNums[i];
                i++;
            }  else {
                nums[k] = rightNums[j];
                j++;
            }

            k++;
        }

        // copy any remaining left array elements
        while (i < leftNums.length) {
            nums[k] = leftNums[i];
            i++;
            k++;
        }

        // copy any remaining right array elements
        while (j < rightNums.length) {
            nums[k] = rightNums[j];
            j++;
            k++;
        }

        System.out.println("nums = " + Arrays.toString(nums) + "\n");
    }

}

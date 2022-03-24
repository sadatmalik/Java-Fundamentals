package labs_examples.sorting_algorithms.labs;

import java.util.Arrays;

/**
 * The Selection Sort is another quadratic sorting algorithm (O(n2)).
 *
 * Like Bubble Sort and Insertion Sort, Selection Sort maintains the idea
 * of having a "sorted" portion of the list, and an "unsorted" portion of
 * the list which we build as we iterate through the list.
 *
 * The Selection Sort repeatedly finds the lowest/smallest element in the
 * list, and moves it to the end of the "sorted" portion of the list. For
 * example, let's assume we have this list of numbers:
 *
 * 34, 24, 8, 11, 7
 *
 * On the first pass of the loop, the Selection Sort will identify 7 as the
 * lowest number, and it will swap 7 & 34. Then it will consider 7 as the
 * beginning of the "sorted" portion of the list.
 *
 * 7   |   24, 8, 11, 34
 *
 * On the second pass, it will identify 8 as the lowest number and swap it
 * with 24. Then it will move the "sorted" indicator one to the right.
 *
 * 7, 8   |   24, 11, 34
 * On the third pass, it will identify 11 as the lowest number and swap it
 * with 24. Then it will move the "sorted" indicator one to the right.
 *
 * 7, 8, 11  |   24, 34
 *
 * On the fourth pass, it will identify 24 as the lowest number but there is
 * no need to swap as it's already in position. All we need to do is move the
 * "sorted" indicator one to the right.
 *
 * 7, 8, 11, 24 | 34
 *
 * On the fifth pass, it will identify 34 as the only (unsorted) number
 * remaining, so we can assume the list is sorted.
 *
 * 7, 8, 11, 24, 34
 *
 * @author sm@creativefusion.net
 */
public class SelectionSort {

    public static void selectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int minPos = i;

            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }

            if (minPos != i) {
                int tmp = nums[i];
                nums[i] = nums[minPos];
                nums[minPos] = tmp;
            }
        }
    }

    public static void recursiveSelectionSort(int[] nums, int index) {

        // Return when starting index and size are same
        if (index == nums.length-1)
            return;

        // calling minimum index function for minimum index
        int k = minIndex(nums, index);

        // Swapping when index nd minimum index are not same
        if (k != index){
            // swap
            int temp = nums[k];
            nums[k] = nums[index];
            nums[index] = temp;
        }
        // Recursively calling selection sort function
        recursiveSelectionSort(nums, index + 1);

    }

    // Return minimum index
    public static int minIndex(int a[], int idx) {
        if (idx == a.length-1)
            return idx;

        // Find minimum of remaining elements
        int k = minIndex(a, idx+1);

        // Return minimum of current and remaining.
        return (a[idx] < a[k]) ? idx : k;
    }

    public static void main(String[] args) {
        int[] nums = {34, 24, 8, 11, 7};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {34, 24, 8, 11, 7};
        recursiveSelectionSort(nums, 0);
        System.out.println(Arrays.toString(nums));
    }
}

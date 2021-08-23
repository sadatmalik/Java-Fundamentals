package labs_examples.generics.labs;

import java.util.*;

/**
 * Generics Exercise 3:
 *
 *      1) Write a generic method that accepts two generic arguments. This generic method should only accept
 *      arguments which are sublasses of Number. The generic method must return the sum (as a double) of whatever two
 *      numbers were passed in regardless of their type.
 *
 *      2) Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes

 *      3) Write a generic method to exchange the positions of two different elements in an array.
 *
 *      4) Write a generic method to find the largest element within the range (begin, end) of a list.
 *
 */

class MoreGenerics {

    public static void main(String[] args) {
        // 1
        System.out.println(sum(1.3, 4));

        // 2
        String[] values = new String[] {"Sadat", "was", "here", "tot", "nan", "hello"};
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(values));

        System.out.println(countPalindromes(strings));

        Set<String> stringSet = new HashSet<>(Arrays.asList(values));
        System.out.println(countPalindromes(stringSet));

        // 3
        swap(values, 0, 4);
        System.out.println(Arrays.toString(values));

        // 4
        Integer[] nums = new Integer[] {3, 5, 2, 7, 5, 3, 4};
        System.out.println(maxElement(nums, 0, 3));

    }

    public static <T extends Number, S extends Number> double sum(T t, S s) {
        return t.doubleValue() + s.doubleValue();
    }

    public static <T extends Collection<String>> int countPalindromes(T t) {
        int count = 0;
        for (String s : t) {
            if (isPalindrome(s)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        boolean palindrome = true;

        for (int i = 0; i < chars.length / 2; i++) {
            if (!(chars[i] == chars[chars.length - (i+1)])) {
                palindrome = false;
            }
        }

        return palindrome;
    }

    public static <T> void swap(T[] t, int pos1, int pos2) {
        T temp;
        temp = t[pos1];
        t[pos1] = t[pos2];
        t[pos2] = temp;
    }

    public static <T extends Number & Comparable<T>> T maxElement(T[] t, int begin, int end) {
        T max = t[begin];
        for (int i = begin+1; i <= end; i++) {
            if (t[i].compareTo(max) > 0) {
                max = t[i];
            }
        }
        return max;
    }


}
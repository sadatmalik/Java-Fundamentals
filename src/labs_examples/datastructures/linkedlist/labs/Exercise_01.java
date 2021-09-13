package labs_examples.datastructures.linkedlist.labs;

import java.util.*;

/**
 *      LinkedLists - Exercise_01
 *
 *      Demonstrate your mastery of Java's built-in LinkedList class by demonstrating the following:
 *
 *      1) create a LinkedList (from Java's libraries)
 *      2) add()
 *      3) addAll()
 *      4) addFirst()
 *      5) addLast()
 *      6) getFirst()
 *      7) getLast()
 *      8) get()
 *      9) set()
 *      10) push()
 *      11) pop()
 *      12) remove()
 *      13) contains()
 *      14) listIterator()
 *      15) clear()
 */

public class Exercise_01 {
    public static void main(String[] args) {
        // 1) create a LinkedList (from Java's libraries)
        LinkedList<String> list = new LinkedList<>();

        //  2) add()
        list.add("Sadat ");
        list.add("was ");
        list.add("here! ");

        // *      3) addAll()
        ArrayList<String> moreWords = new ArrayList<>();
        moreWords.add("Some ");
        moreWords.add("more ");
        moreWords.add("words ");
        list.addAll(moreWords);

        // *      4) addFirst()
        list.addFirst("First ");

        // *      5) addLast()
        list.addLast("Last ");

        // *      6) getFirst()
        System.out.println("First = " + list.getFirst());

        // *      7) getLast()
        System.out.println("Last = " + list.getLast());

        // *      8) get()
        System.out.println("Second element = " + list.get(1));

        // *      9) set()
        list.set(list.size()-2, "Penultimate ");

        // *      10) push()
        list.push("Popped");

        // *      11) pop()
        System.out.println(list.pop());

        // *      12) remove()
        list.remove("more ");

        // *      13) contains()
        if (!list.contains("more ")) {
            System.out.println("No more");
        }

        // *      14) listIterator()
        ListIterator<String> iter = list.listIterator();
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }

        // *      15) clear()
        list.clear();
    }
}
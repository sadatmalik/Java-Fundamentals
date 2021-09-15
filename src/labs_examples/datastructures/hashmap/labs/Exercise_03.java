package labs_examples.datastructures.hashmap.labs;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Consumer;

/**
 *      HashMaps Exercise_02
 *
 *      Create a new class that does the following:
 *
 *      1) create a LinkedList
 *      2) create a Stack
 *      3) create a Queue
 *      4) create a HashMap
 *
 *      Then, add millisecond timers before and after each data structure above and print out
 *      how long it takes for each to complete EACH the following tasks, and the total time for
 *      each data structure:
 *
 *      1) add 100 elements
 *      2) update 100 elements
 *      3) search for 100 elements
 *      4) delete 100 elements
 */

public class Exercise_03 {

    static LinkedList<Integer> list = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new PriorityQueue<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        add(100);
        update(100);
        search(100);
        delete(100);
    }

    private static <T> void executionTimer(Consumer<T> func, T t, String msg) {

        Instant start = Instant.now();

        func.accept(t);

        Instant finish = Instant.now();
        System.out.println(msg + ": " + Duration.between(start, finish).toNanos() + " ns, ");

    }

    private static void add(int x) {

        Consumer<LinkedList<Integer>> addToList = (l) -> {
            for (int i = 0; i < x; i++) {
                l.add(i);
            }
        };
        executionTimer(addToList, list, "Add " + x + " elements to LinkedList");

        Consumer<Stack<Integer>> addToStack = (s) -> {
            for (int i = 0; i < x; i++) {
                s.add(i);
            }
        };
        executionTimer(addToStack, stack, "Add " + x + " elements to Stack");

        Consumer<Queue<Integer>> addToQueue = (q) -> {
            for (int i = 0; i < x; i++) {
                q.add(i);
            }
        };
        executionTimer(addToQueue, queue, "Add " + x + " elements to PriorityQueue");

        Consumer<Map<Integer, Integer>> addToMap = (m) -> {
            for (int i = 0; i < x; i++) {
                m.put(i, i);
            }
        };
        executionTimer(addToMap, map, "Add " + x + " elements to HashMap");

        System.out.println();
    }

    private static void update(int x) {
        Consumer<LinkedList<Integer>> updateList = (l) -> {
            for (int i = 0; i < x; i++) {
                int j = l.get(i);
                l.add(j + 1);
            }
        };
        executionTimer(updateList, list, "Update " + x + " elements to LinkedList");

        Consumer<Stack<Integer>> updateStack = (s) -> {
            for (int i = 0; i < x; i++) {
                int j = s.get(i);
                s.add(j + 1);
            }
        };
        executionTimer(updateStack, stack, "Update " + x + " elements to Stack");

        Consumer<Queue<Integer>> updateQueue = (q) -> {
            for (int i = 0; i < x; i++) {
                q.remove();
                q.add(i + 1);
            }
        };
        executionTimer(updateQueue, queue, "Update " + x + " elements to PriorityQueue");

        Consumer<Map<Integer, Integer>> addToMap = (m) -> {
            for (int i = 0; i < x; i++) {
                m.replace(i, i+1);
            }
        };
        executionTimer(addToMap, map, "Update " + x + " elements to HashMap");

        System.out.println();
    }

    private static void search(int x) {
        Consumer<LinkedList<Integer>> searchList = (l) -> {
            for (int i = 0; i < x; i++) {
                int j = l.get(i);
            }
        };
        executionTimer(searchList, list, "Search " + x + " elements to LinkedList");

        Consumer<Stack<Integer>> searchStack = (s) -> {
            for (int i = 0; i < x; i++) {
                int j = s.get(i);
            }
        };
        executionTimer(searchStack, stack, "Search " + x + " elements to Stack");

        Consumer<Queue<Integer>> searchQueue = (q) -> {
            for (int i = 0; i < x; i++) {
                Iterator iter = q.iterator();
                while (iter.hasNext()) {
                    if ((int)iter.next() == i) {
                        break;
                    }
                }
            }
        };
        executionTimer(searchQueue, queue, "Search " + x + " elements to PriorityQueue");

        Consumer<Map<Integer, Integer>> searchMap = (m) -> {
            for (int i = 0; i < x; i++) {
                m.get(i);
            }
        };
        executionTimer(searchMap, map, "Update " + x + " elements to HashMap");

        System.out.println();
    }

    private static void delete(int x) {
        Consumer<LinkedList<Integer>> deleteList = (l) -> {
            for (int i = 0; i < x; i++) {
                l.remove(i);
            }
        };
        executionTimer(deleteList, list, "Delete " + x + " elements to LinkedList");

        Consumer<Stack<Integer>> deleteStack = (s) -> {
            for (int i = 0; i < x; i++) {
                s.remove(i);
            }
        };
        executionTimer(deleteStack, stack, "Delete " + x + " elements to Stack");

        Consumer<Queue<Integer>> deleteQueue = (q) -> {
            for (int i = 0; i < x; i++) {
                q.remove();
            }
        };
        executionTimer(deleteQueue, queue, "Delete " + x + " elements to PriorityQueue");

        Consumer<Map<Integer, Integer>> deleteMap = (m) -> {
            for (int i = 0; i < x; i++) {
                m.remove(i);
            }
        };
        executionTimer(deleteMap, map, "Delete " + x + " elements to HashMap");

        System.out.println();
    }
}
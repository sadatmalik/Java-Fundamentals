package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *  HashMaps Exercise_01
 *
 *  Demonstrate you're mastery of using Java's built-in HashMap class below.
 *
 *  Using a HashMap demonstrate the use of the following methods:
 *
 *  put()
 *  get()
 *  putAll()
 *  size()
 *  contains()
 *  keySet()
 *  entrySet()
 *  putIfAbsent()
 *  remove()
 *  replace()
 *  forEach()
 *  clear()
 *
 */
public class Exercise_01 {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();

        // put()
        ages.put("John", 43);
        ages.put("Jane", 27);
        ages.put("Emily", 7);
        ages.put("Naoko", 64);

        // get()
        for (Map.Entry age : ages.entrySet()) {
            System.out.println(age.getKey() + " is " + age.getValue() + " years old.");
        }

        // putAll()
        Map<String, Integer> moreAges = new HashMap();
        moreAges.put("Chloe", 37);
        moreAges.put("Veronika", 54);
        ages.putAll(moreAges);

        // *  size()
        System.out.println("Size = " + ages.size());

        // *  contains()
        if (ages.containsKey("Chloe")) {
            System.out.println("Found Chloe");
        }

        // *  keySet()
        Set<String> keys = ages.keySet();
        for (String s : keys) {
            System.out.println(s);
        }

        // *  entrySet()
        Set<Map.Entry<String, Integer>> entries = ages.entrySet();
        for (Map.Entry<String, Integer> e : entries) {
            System.out.println(e.getKey() + " is " + e.getValue());
        }

        // *  putIfAbsent()
        ages.putIfAbsent("Sinead", 3);
        int i = ages.putIfAbsent("Sinead", 4); // will return existing value '3'
        System.out.println(i);

        // *  remove()
        System.out.println(ages.remove("Sinead")); // returns 3 and removes

        // *  replace()
        ages.replace("John", 44);
        System.out.println(ages.get("John")); // now 44

        // *  forEach()
        ages.forEach((k, v) -> System.out.println(k + " is " + v));

        // *  clear()
        ages.clear();
        System.out.println(ages.size()); // 0
    }
}
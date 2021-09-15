package labs_examples.datastructures.hashmap.labs;

/**
 *      HashMaps Exercise_02
 *
 *      Rewrite the CustomHashMap class to meet the following requirements:
 *      ok - 1) no method has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      ok - 2) no variable has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      ok - 3) resize the HashMap when the underlying array is more than half full
 *      ok- 4) triple the size of the underlying array on resize()
 *      ok - checking number of Entry's - 5) instead of checking the number of keys to resize, check the number of values
 *      ok - 6) on collisions, add new elements to the front of the LinkedList, not the end
 *      ok - 7) anytime someone tries to get/update/remove an element that does not exist, print
 *          out a message indicating that the element does not exist
 *      ok - 8) add at least one more method that you think could be useful to the HashMap
 *          review Java's built-in HashMap for inspiration
 */

class CustomHashMap<K, V> {

    // array to hold the pairs
    Entry<K, V>[] entries = new Entry[10];

    // numEntries
    int numEntries = 0;

    // work out key hash
    private int getHash(K key) {
        return Math.abs(key.hashCode() % entries.length);
    }

    public void add(K key, V value) {
        // create an entry
        Entry<K, V> entry = new Entry<>(key, value);

        // get the hash index
        int index = getHash(key);

        // if nothing at that index just add it
        if (entries[index] == null) {
            entries[index] = entry;
            numEntries++;
        } else {

            // else add it to the start of the linked list
            Entry<K, V> list = entries[index];
            entry.next = list;
            entries[index] = entry;
            numEntries++;
        }

        // resize when underlying array is over half full
        if (numEntries > entries.length / 2) {
            resize();
        }
    }

    // resize the underlying entries array
    private void resize() {
        // keep a copy of the old entries
        Entry<K, V>[] old = entries;

        // create a new entries array
        entries = new Entry[old.length * 3];

        // copy old entries to new array
        for (int i = 0; i < old.length; i++) {
            if (old[i] != null) {
                // get the entry
                Entry<K, V> entry = old[i];

                // if it's a single element just add it to the new array
                if (entry.next == null) {
                    add(entry.getKey(), entry.getValue());
                }
                // otherwise, add each element one at a time
                else {
                    while (entry.next != null) {
                        add(entry.getKey(), entry.getValue());
                        entry = entry.next;
                    }
                    add(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public V getValueFor(K key) {
        int index = getHash(key);

        // if no entry at that index return null
        if (entries[index] == null) {
            System.out.println("No such key '" + key + "' in Map");
            return null;
        }

        // if a single entry at that index return that entry's key
        else if (entries[index].next == null) {
            return entries[index].getValue();
        }

        // if a list at that index, search through list for a key match
        else {
            Entry<K, V> head = entries[index];
            while (head.next != null) {
                if (head.getKey() == key) {
                    return head.getValue();
                }
                head = head.next;
            }
            if (head.getKey() == key) {
                return head.getValue();
            }
        }

        System.out.println("No such key '" + key + "' in Map");
        return null;
    }

    public void delete(K key) {
        int index = getHash(key);

        // if no entry at hash index
        if (entries[index] == null) {
            System.out.println("No such key '" + key + "' in Map");
            return;
        }

        // if single entry at hash index delete it if match
        else if (entries[index].next == null) {
            if (entries[index].getKey() == key) {
                entries[index] = null;
                return;
            }
        }

        // otherwise, check if it's in the list of entries and remove it
        else {
            Entry<K, V> head = entries[index];
            // if the head matches, cut it out
            if (head.getKey() == key) {
                entries[index] = head.next;
                numEntries--;
                return;
            }

            // iterate through to last entry
            else {
                while (head.next != null) {
                    // if the next entry matches, cut it out
                    if (head.next.getKey() == key) {
                        head.next = head.next.next;
                        numEntries--;
                        return;
                    }
                }
            }
        }
        System.out.println("No such key '" + key + "' in Map");
    }

    public void clear() {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                entries[i] = null;
            }
        }
        numEntries = 0;
    }

    public boolean isEmpty() {
        return numEntries == 0;
    }
}

class Entry<K, V> {
    private K key;
    private V value;

    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

public class Exercise_02 {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> numbers = new CustomHashMap<>();

        // add
        numbers.add("Zero", 0);
        numbers.add("One", 1);
        numbers.add("Two", 2);
        numbers.add("Three", 3);
        numbers.add("Four", 4);
        numbers.add("Five", 5);
        numbers.add("Six", 6);
        numbers.add("Seven", 7);
        numbers.add("Eight", 8);
        numbers.add("Nine", 9);

        // getValueFor
        printValuesForAllKeys(numbers);

        // delete
        numbers.delete("Two");
        printValuesForAllKeys(numbers);

        // isEmpty + clear
        System.out.println("Map isEmpty? = " + numbers.isEmpty());
        System.out.println("Clear map");
        numbers.clear();
        System.out.println("Map isEmpty? = " + numbers.isEmpty());
    }

    private static void printValuesForAllKeys(CustomHashMap<String, Integer> numbers) {
        System.out.println(numbers.getValueFor("Zero"));
        System.out.println(numbers.getValueFor("One"));
        System.out.println(numbers.getValueFor("Two"));
        System.out.println(numbers.getValueFor("Three"));
        System.out.println(numbers.getValueFor("Four"));
        System.out.println(numbers.getValueFor("Five"));
        System.out.println(numbers.getValueFor("Six"));
        System.out.println(numbers.getValueFor("Seven"));
        System.out.println(numbers.getValueFor("Eight"));
        System.out.println(numbers.getValueFor("Nine"));
    }
}
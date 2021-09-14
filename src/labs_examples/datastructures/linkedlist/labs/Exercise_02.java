package labs_examples.datastructures.linkedlist.labs;

/**
 *      LinkedLists - Exercise_02
 *
 *      Write your own custom LinkedList class. Although it can mimic the CustomLinkedList
 *      class we used here, it must be entirely unique. Please also add at least two
 *      additional helper methods that you think could be useful. Refer to Java's built-in
 *      LinkedList class for inspiration. Your new LinkedList class should ONLY allow users
 *      to add and remove elements from the front of the list AND the end of the list.
 *      Also, instead of using the index in the get() and remove() methods, these methods should
 *      get() and remove() based by the Node's value, not it's index.
 */

public class Exercise_02 {

    public static void main(String[] args) {
        CustomDoublyLinkedList<String> myList = new CustomDoublyLinkedList<>();

        myList.add("Sadat");
        myList.add("was");
        myList.add("here");
        myList.add("one");
        myList.add("more");
        myList.add("time!");
        System.out.println(myList);

        myList.remove();
        System.out.println(myList);

        myList.remove("was");
        System.out.println(myList);

        myList.remove("no such entry");
        System.out.println(myList);

        String got = myList.get("Sadat");
        System.out.println("Got = " + got);
        System.out.println(myList);

        String notGot = myList.get("John");
        System.out.println(myList);

        myList.push("Mr.");
        System.out.println(myList);

        String popped = myList.pop();
        System.out.println("Popped = " + popped);
        System.out.println(myList);

        System.out.println("Head = " + myList.head());
        System.out.println("Tail = " + myList.tail());

        myList.insertAfter("Sadat", "Malik");
        System.out.println(myList);
        myList.insertAfter("more", "time");
        System.out.println(myList);

        myList.insertBefore("Sadat", "Mr.");
        System.out.println(myList);
        myList.insertBefore("one", "again");
        System.out.println(myList);

        while (myList.size() != 0) {
            System.out.println("Popped = " + myList.pop());
        }

    }
}

class CustomDoublyLinkedList<T> {

    private Node<T> head;
    private int size = 0;

    public CustomDoublyLinkedList() {
        this.head = null;
    }

    public void add(T data) {

        if (head == null) {
            head = new Node(data);
            size = 1;

        } else {

            int index = 0;
            Node currentNode = head;
            while (index < size-1) {
                currentNode = currentNode.next;
                index++;
            }
            currentNode.next = new Node(currentNode, data, null);
            size++;
        }
    }

    public void push(T data) {

        if (head == null) {
            head = new Node(data);
            size = 1;

        } else {
            head = new Node(null, data, head);
            size++;
        }

    }

    public void remove() {
        if (head != null) {

            Node currentNode = head;

            // iterate to last node in list
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.prev.next = null;
            size--;

        }
    }

    public void remove(T data) {
        if (head != null) {

            Node currentNode = head;

            // iterate through nodes
            try {
                while (currentNode.data != data) {
                    currentNode = currentNode.next;
                }

                currentNode.prev.next = currentNode.next;
                size--;

            } catch (NullPointerException npe) {
                System.out.println("No such element in list: " + data);
            }

        }
    }

    public T get(T data) {
        T value = null;

        if (head != null) {

            Node<T> currentNode = head;

            // iterate through nodes
            try {
                while (currentNode.data != data) {
                    currentNode = currentNode.next;
                }

                value = currentNode.data;

            } catch (NullPointerException npe) {
                System.out.println("No such element in list: " + data);
            }

        }

        return value;
    }

    public T pop() {
        Node<T> popped = null;

        if (head != null) {
            popped = head;

            head = head.next;
            size--;
        }
        return popped.data;
    }

    public T head() {
        return head.data;
    }

    public T tail() {
        Node<T> currentNode = head.next;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public int size() {
        return size;
    }

    // Added these methods for Exercise_03 - insertAfter, insertBefore
    public void insertAfter(T data, T newData) {
        Node<T> currentNode = head;
        try {
            while (currentNode.data != data) {
                currentNode = currentNode.next;
            }
            Node<T> newNode = new Node(currentNode, newData, currentNode.next);
            if (currentNode.next != null) {
                currentNode.next.prev = newNode;
            }
            currentNode.next = newNode;
            size++;

        } catch (NullPointerException npe) {
            System.out.println("No such element in list: " + data);
        }
    }

    public void insertBefore(T data, T newData) {
        Node<T> currentNode = head;
        try {
            while (currentNode.data != data) {
                currentNode = currentNode.next;
            }
            Node<T> newNode = new Node<>(currentNode.prev, newData, currentNode);
            if (currentNode.prev == null) {
                head = newNode;
            } else {
                currentNode.prev.next = newNode;
            }
            currentNode.prev = newNode;
            size++;

        } catch (NullPointerException npe) {
            System.out.println("No such element in list: " + data);
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node currentNode = head;

        for (int i = 0; i < size; i++) {
            sb.append(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        return sb.toString();
    }

}

class Node<T> {

    T data;
    Node next;
    Node prev;

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Node(Node prev, T data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
package labs_examples.datastructures.trees.labs;

import labs_examples.datastructures.linkedlist.examples.Node;

/*
    Trees: Exercise_01

    Please demonstrate how to create a custom Binary Search Tree (BST). Using your custom BST, demonstrate how to:

        1.) Create a new CustomBST - ok
        2.) Insert new elements - ok
        3.) Retrieve elements
        4.) Update elements
        5.) Delete elements
        6.) Print elements (Bonus: try in-order traversal, pre-order traversal, post-order traversal) - ok
        7.) Keep the tree well balanced

 */
class CustomBST<K extends Comparable<K> ,V> {
    private Node<K, V> root;

    public void insert(K key, V value) {
        // if empty, set root to new node
        if (root == null) {
            root = new Node<>(key, value);;
        }
        // else insert node into root tree
        else {
            insert(key, value, root);
        }
    }

    private void insert(K key, V value, Node root) {
        // if key < root go left
        if (key.compareTo((K)root.key) < 0) {
            if (root.leftChild == null) {
                root.leftChild = new Node(key, value);
            } else {
                insert(key, value, root.leftChild);
            }
        }
        // if > root go right
        else if (key.compareTo((K)root.key) > 0) {
            if (root.rightChild == null) {
                root.rightChild = new Node(key, value);
            } else {
                insert(key, value, root.rightChild);
            }
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            traverseInOrder(root);
        } else {
            System.out.println(root.value);
        }
    }

    public void traversePreOrder() {
        if (root != null) {
            traversePreOrder(root);
        } else {
            System.out.println(root.value);
        }
    }

    public void traversePostOrder() {
        if (root != null) {
            traversePreOrder(root);
        } else {
            System.out.println(root.value);
        }
    }

    private void traverseInOrder(Node<K, V> node) {
        if (node.leftChild != null) {
            traverseInOrder(node.leftChild);
        }
        System.out.println(node.value);
        if (node.rightChild != null) {
            traverseInOrder(node.rightChild);
        }
    }

    private void traversePreOrder(Node<K, V> node) {
        System.out.println(node.value);
        if (node.leftChild != null) {
            traverseInOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            traverseInOrder(node.rightChild);
        }
    }

    private void traversePostOrder(Node<K, V> node) {
        if (node.leftChild != null) {
            traverseInOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            traverseInOrder(node.rightChild);
        }
        System.out.println(node.value);
    }

    class Node<K, V> {
        K key;
        V value;

        Node<K, V> leftChild;
        Node<K, V> rightChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;

            this.leftChild = null;
            this.rightChild = null;
        }

    }
}

public class Exercise_01 {
    public static void main(String[] args) {
        CustomBST<Integer, String> bst = new CustomBST<>();

        bst.insert(20, "Twenty");
        bst.insert(27, "Twenty-Seven");
        bst.insert(23, "Twenty-Three");
        bst.insert(32, "Thirty-Two");
        bst.insert(43, "Forty-Three");
        bst.insert(56, "Fifty-Six");
        bst.insert(34, "Thirty-Four");
        bst.insert(17, "Seventeen");
        bst.insert(37, "Thirty-Seven");

        System.out.println("In order traversal");
        bst.traverseInOrder();

        System.out.println("\nPre order traversal");
        bst.traversePreOrder();

        System.out.println("\nPost order traversal");
        bst.traversePostOrder();

    }
}

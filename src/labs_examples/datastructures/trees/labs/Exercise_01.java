package labs_examples.datastructures.trees.labs;

import labs_examples.datastructures.linkedlist.examples.Node;

/*
    Trees: Exercise_01

    Please demonstrate how to create a custom Binary Search Tree (BST). Using your custom BST, demonstrate how to:

        1.) Create a new CustomBST - ok
        2.) Insert new elements - ok
        3.) Retrieve elements - ok
        4.) Update elements
        5.) Delete elements -
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

    private void insert(K key, V value, Node node) {

        // if key < root go left
        if (key.compareTo((K)node.key) < 0) {
            if (node.leftChild == null) {
                node.leftChild = new Node(key, value);
            } else {
                insert(key, value, node.leftChild);
            }
        }
        // if > root go right
        else if (key.compareTo((K)node.key) > 0) {
            if (node.rightChild == null) {
                node.rightChild = new Node(key, value);
            } else {
                insert(key, value, node.rightChild);
            }
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            traverseInOrder(root);
        }
        return;
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
            traversePostOrder(root);
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
            traversePreOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            traversePreOrder(node.rightChild);
        }
    }

    private void traversePostOrder(Node<K, V> node) {
        if (node.leftChild != null) {
            traversePostOrder(node.leftChild);
        }
        if (node.rightChild != null) {
            traversePostOrder(node.rightChild);
        }
        System.out.println(node.value);
    }

    public V retrieve(K key) {
        // if empty, return null
        if (root == null) {
            return null;
        }

        return retrieve(key, root);

    }

    private V retrieve(K key, Node<K, V> node) {
        // if matches node, return value
        if (key.equals(node.key)) {
            return node.value;
        }

        // traverse left sub-tree
        if (key.compareTo((K)node.key) < 0) {
            if (node.leftChild != null) {
                return retrieve(key, node.leftChild);
            }
        }
        // travers right sub-tree
        else if (key.compareTo((K)node.key) > 0) {
            if (node.rightChild != null) {
                return retrieve(key, node.rightChild);
            }
        }

        // not found
        return null;
    }

    public void delete(K key) {
        if (root == null) {
            return;
        }
        root = delete(key, root);
    }

    private Node<K, V> delete(K key, Node<K, V> node) {

        // found a match - remove the node, 4 cases:
        if (key == node.key) {
            // Case 1 - node has 0 children
            if (node.leftChild == null && node.rightChild == null) {
                return null;
            }
            // Case 2 - no left child
            else if (node.leftChild == null) {
                return node.rightChild;
            }
            // Case 3 - no right child
            else if (node.rightChild == null) {
                return node.leftChild;
            }
            // Case 4 - node has 2 children
            else {
                // set node's K and V  to the K and V of the min of the right sub-tree
                Node successor = min(node.rightChild);
                node.key = (K)successor.key;
                node.value = (V)successor.value;

                // delete the min of the right sub-tree
                node.rightChild = delete(node.key, node.rightChild);
            }
        }

        // delete from left sub-tree if key < current note key
        else if (key.compareTo(node.key) < 0) {
            if (node.leftChild != null) {
                node.leftChild = delete(key, node.leftChild);
            }
        }

        // delete from right sub-tree if key > current node key
        else if (key.compareTo(node.key) > 0) {
            if (node.rightChild != null) {
                node.rightChild = delete(key, node.rightChild);
            }
        }

        return node;
    }

    public V min() {
        if (root == null) {
            return null;
        }
        return (V)min(root).value;
    }

    private Node min(Node<K, V> node) {
        if (node.leftChild == null) {
            return node;
        }
        return min(node.leftChild);
    }

    public V max() {
        if (root == null) {
            return null;
        }
        return (V)max(root).value;
    }

    private Node max(Node<K, V> node) {
        if (node.rightChild == null) {
            return node;
        }
        return max(node.rightChild);
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
        bst.insert(9, "Nine");
        bst.insert(19, "Nineteen");
        bst.insert(18, "Eighteen");
        bst.insert(7, "Seven");
        bst.insert(5, "Five");

        System.out.println("In order traversal");
        bst.traverseInOrder();

        System.out.println("\nPre order traversal");
        bst.traversePreOrder();

        System.out.println("\nPost order traversal");
        bst.traversePostOrder();

        System.out.println("\nRetrieval");
        System.out.println("Key(20) = " + bst.retrieve(20));
        System.out.println("Key(43) = " + bst.retrieve(43));
        System.out.println("Key(17) = " + bst.retrieve(17));
        System.out.println("Key(37) = " + bst.retrieve(37));

        System.out.println("\nMin/Max");
        System.out.println("Min = " + bst.min());
        System.out.println("Max = " + bst.max());

        System.out.println("\nDelete");
        System.out.println("Delete(5) - no children");
        bst.delete(5);
        bst.traverseInOrder();

        System.out.println("\nDelete(19) - left child only");
        bst.delete(19);
        bst.traverseInOrder();

        System.out.println("\nDelete(34) - right child only");
        bst.delete(34);
        bst.traverseInOrder();

        System.out.println("\nDelete(9) - left and right child");
        bst.delete(9);
        bst.traverseInOrder();

        System.out.println("\nDelete(9) - no such node");
        bst.delete(9);
        bst.traverseInOrder();

    }
}

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
            root = insert(key, value, root);
        }
    }

    private Node<K, V> insert(K key, V value, Node node) {

        if (node == null) {
            node = new Node(key, value);
        }

        // if key < node go left
        if (key.compareTo((K)node.key) < 0) {
            node.leftChild = insert(key, value, node.leftChild);
        }
        // if key > node go right
        else if (key.compareTo((K)node.key) > 0) {
            node.rightChild = insert(key, value, node.rightChild);
        }
        // prevent duplicates
        else {
            return node;
        }

        // re-balance the tree after insertion
        return balanceInsert(node);
    }

    private Node<K, V> balanceInsert(Node<K, V> node) {
        // check balance factor
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);

        int balanceFactor = leftHeight - rightHeight;

        // if left heavy, balance factor > 1;
        if (balanceFactor > 1) {
            // if left child is left heavy or balanced
            if (isLeftHeavy(node.leftChild)) {
                node = rotateRight(node);
            }
            // if left child is right heavy
            else {
                node = rotateLeftRight(node);
            }
        }

        // if right heavy balance factor < -1;
        else if (balanceFactor < -1) {
            // if right child is right heavy or balanced
            if (isRightHeavy(node.rightChild)) {
                node = rotateLeft(node);
            }
            // else if right child is left heavy
            else {
                node = rotateRightLeft(node);
            }
        }

        return node;
    }

    private int height(Node<K, V> node) {
        if (node != null) {
            return node.height;
        }
        return -1;
    }

    private Node<K, V> rotateRight(Node<K, V> node) {
        Node<K, V> newHead = node.leftChild;
        node.leftChild = node.leftChild.rightChild;
        newHead.rightChild = node;

        // set new node height after any rotations
        int leftHeight = height(newHead.leftChild);
        int rightHeight = height(newHead.rightChild);

        newHead.height = 1 + Math.max(leftHeight, rightHeight);

        // set new head's left child height
        leftHeight = height(newHead.leftChild.leftChild);
        rightHeight = height(newHead.leftChild.rightChild);

        newHead.leftChild.height = 1 + Math.max(leftHeight, rightHeight);

        return newHead;
    }

    private Node<K, V> rotateLeft(Node<K, V> node) {
        Node<K, V> newHead = node.rightChild;
        node.rightChild = node.rightChild.leftChild;
        newHead.leftChild = node;

        // set new node height after any rotations
        int leftHeight = height(newHead.leftChild);
        int rightHeight = height(newHead.rightChild);

        newHead.height = 1 + Math.max(leftHeight, rightHeight);

        // set new head's right child height
        leftHeight = height(newHead.rightChild.leftChild);
        rightHeight = height(newHead.rightChild.rightChild);

        newHead.rightChild.height = 1 + Math.max(leftHeight, rightHeight);

        return newHead;
    }

    private Node<K, V> rotateLeftRight(Node<K, V> node) {
        node.leftChild = rotateLeft(node.leftChild);
        return rotateRight(node);
    }

    private Node<K, V> rotateRightLeft(Node<K, V> node) {
        node.rightChild = rotateRight(node.rightChild);
        return rotateLeft(node);
    }

    // return true if node is left heavy or balanced
    private boolean isLeftHeavy(Node<K,V> node) {
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);

        return leftHeight >= rightHeight;
    }

    // return true if node is right heavy or balanced
    private boolean isRightHeavy(Node<K, V> node) {
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);

        return rightHeight >= leftHeight;
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

        // quick search and return if the node doesn't exist


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

        // recursion - delete from left sub-tree if key < current note key
        else if (key.compareTo(node.key) < 0) {
            if (node.leftChild != null) {
                node.leftChild = delete(key, node.leftChild);
            }
        }

        // recursion - delete from right sub-tree if key > current node key
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

        int height;

        Node<K, V> leftChild;
        Node<K, V> rightChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;

            height = 0;

            this.leftChild = null;
            this.rightChild = null;
        }

    }
}

public class Exercise_01 {
    public static void main(String[] args) {
        CustomBST<Integer, String> bst = new CustomBST<>();

//        bst.insert(3, "Three");
//        bst.insert(7, "Seven");
//        bst.insert(1, "One");
//        bst.insert(5, "Five");
//        bst.insert(2, "Two");
//        bst.insert(4, "Four");
//        bst.insert(6, "Six");

        bst.insert(20, "Twenty");
        bst.insert(27, "Twenty-Seven"); // right add ok
        bst.insert(23, "Twenty-Three"); // right tree lost
        bst.insert(32, "Thirty-Two"); // right add ok
        bst.insert(43, "Forty-Three"); // right tree lost
        bst.insert(56, "Fifty-Six"); // right add ok
        bst.insert(34, "Thirty-Four"); //right tree lost
        bst.insert(17, "Seventeen"); // left add ok
        bst.insert(37, "Thirty-Seven"); // right add ok
        bst.insert(9, "Nine"); // left add ok
        bst.insert(19, "Nineteen"); // left add ok
        bst.insert(18, "Eighteen"); // left tree lost
        bst.insert(7, "Seven"); // left add ok
        bst.insert(5, "Five"); // left add ok

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

        System.out.println("\nDelete(20) - left and right child");
        bst.delete(20);
        bst.traverseInOrder();

        System.out.println("\nDelete(20) - no such node");
        bst.delete(20);
        bst.traverseInOrder();

    }
}

package labs_examples.datastructures.trees.labs;

import java.util.HashMap;
import java.util.Map;

/*
    Trees: Exercise_02

    For this challenge, please research and implement a custom Trie data structure (https://en.wikipedia.org/wiki/Trie).

    Trie's are very interesting and useful data structures. Many interview questions, and real-world scenario's
    can be properly addressed using a Trie. We use Tries to store things like words and numbers in a highly
    efficient manner. See here: http://theoryofprogramming.com/wp-content/uploads/2015/06/trie12.jpg

    Understanding and implement a Trie is a fantastic step in thinking creatively as a developer to
    accomplish goals as efficiently as possible.

    Here is a fantastic set of relevant interview questions: https://www.techiedelight.com/trie-interview-questions/

 */
class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    // insert string
    void insert(String s) {
        insert(root, s);
    }

    void insert(Node node, String s) {
        if (s.equals("")) {
            node.endOfWord = true;
            return;
        } else {
            if (!node.children.containsKey(s.charAt(0))) {
                node.children.put(s.charAt(0), new Node());
            }
            insert(node.children.get(s.charAt(0)), s.substring(1, s.length()));
        }
    }

}

class Node {
    Map<Character, Node> children;
    boolean endOfWord;

    Node() {
        children = new HashMap<>();
        endOfWord = false;
    }

}

class Exercise_02 {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("Sadat");
    }
}
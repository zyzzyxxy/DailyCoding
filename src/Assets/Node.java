package Assets;

/**
 * Since a lot of tasks involves trees i figured it´s best to prepare a reusable node class for building binary trees.
 */

public class Node {
    //public for testing conveniance
    public int value;
    public Node left, right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
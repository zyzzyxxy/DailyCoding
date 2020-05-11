package p110_to_119;

import Assets.*;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Google.
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 */
public class Problem115 {

    Node root1 = new Node(1,
                    new Node(2,null,null),
                    new Node(3, null, null));

    Node root2 = new Node(5, null, new Node(1,
            new Node(2,null,null),
            new Node(3, null, null)));

    Node root3 = new Node(1,
            new Node(2,null,null),
            new Node(4, null, null));


    public Problem115() {
        Assets.Printer printer = new Printer();
        printer.printTree(root1);

    }
}

package p110_to_119;
import Assets.*;
/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Facebook.
 *
 * Given a binary tree, return all paths from the root to leaves.
 *
 * For example, given the tree:
 *
 *    1
 *   / \
 *  2   3
 *     / \
 *    4   5
 * Return [[1, 2], [1, 3, 4], [1, 3, 5]].
 */

public class Problem110 {
    Node rt = new Node(1,
                        new Node(2,null,null),
                        new Node(3, new Node(4,null,null),
                                new Node(5, null, null)));

    public Problem110(){
        System.out.println(rt.value);
        System.out.println(rt.isLeaf());
        System.out.println(rt.left.isLeaf());
    }

}

package Week43;

import java.util.ArrayList;

/**
 * This problem was asked by Google.
 * <p>
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
 * <p>
 * For example, given the following Node class
 * <p>
 * class Node:
 * def __init__(self, val, left=None, right=None):
 * self.val = val
 * self.left = left
 * self.right = right
 * The following test should pass:
 * <p>
 * node = Node('root', Node('left', Node('left.left')), Node('right'))
 * assert deserialize(serialize(node)).left.left.val == 'left.left'
 */
public class Problem3 {

    public Problem3() {
        Node node = new Node("root",new Node("left",new Node("left.left")),new Node("right"));
        ArrayList<String> str = serialize(node);
        Node newNode = deserialize(str);

        System.out.println(serialize(node));
        System.out.println(serialize(newNode));
    }

    private ArrayList<String> serialize(Node node) {
        ArrayList<String> result = new ArrayList<>();
        if(node.left!=null)
            result.addAll(serialize(node.left));
        result.add(node.value);
        if(node.right!=null)
            result.addAll(serialize(node.right));
        return result;
    }
    private Node addValueToRight(String value, Node node){
        if (node==null){
            return new Node(value);
        }
        if(node.right==null){
            node.right = new Node(value);
            return node;
        }
        else{
            return new Node(value,node);
        }
    }
    private Node deserialize(ArrayList<String> s){
        Node node = null;
        for (String str :s) {
            node = addValueToRight(str,node);
        }
        return node;
    }

    //Not implemented
    public class Node {
        String value;
        Node left;
        Node right;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
        public Node(String value, Node left) {
            this.value = value;
            this.left = left;
            this.right = null;
        }
        public Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }



}

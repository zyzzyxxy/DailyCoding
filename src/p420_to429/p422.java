package p420_to429;


import Assets.BinaryTree;
import Assets.Node;

/**
 * This problem was asked by Salesforce.
 *
 * Write a program to merge two binary trees. Each node in the new tree should hold a value equal to the sum of the values of the corresponding nodes of the input trees.
 *
 * If only one input tree has a node in a given position, the corresponding node in the new tree should match that input node.
 */


public class p422 {

    BinaryTree tree1;
    BinaryTree tree2;

    public p422() {
        init();
    }

    public void test(){
        tree1.printTree();
        System.out.println("");
        System.out.println("Levels: " + tree1.getHeight());
    }

    public void init(){
        tree1 = new BinaryTree(2);
        tree2 = new BinaryTree(10);
    }

}

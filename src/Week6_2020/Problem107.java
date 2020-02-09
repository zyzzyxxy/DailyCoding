package Week6_2020;
/*      This problem was asked by Microsoft.

        Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.

      1
     / \
    2   3
   /   / \
 0    4   5
added the 0 myself to see really level traversal
        */

import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem107 {
    public Problem107(){
        BinaryTree bt = new BinaryTree(1,
                        new BinaryTree(2,
                                new BinaryTree(0,null,null),null),
                        new BinaryTree(3,
                                new BinaryTree(4, null, null),
                                new BinaryTree(5, null, null)));
        printTree(bt);
    }

    class BinaryTree {
        BinaryTree left;
        BinaryTree right;
        int value;

        public BinaryTree(int val,BinaryTree left,BinaryTree right){
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }

    void printTree(BinaryTree t){
        Queue<BinaryTree> queue = new LinkedList();
        queue.add(t);
        while (!queue.isEmpty()){
            BinaryTree temp_tree = queue.poll();
            System.out.print(temp_tree.value);
            if(temp_tree.left!=null)
                queue.add(temp_tree.left);
            if(temp_tree.right!=null)
                queue.add(temp_tree.right);
        }
    }




}



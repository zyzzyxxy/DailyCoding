package Assets;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class BinaryTree {

    Node root;
    int lowBound = 0;
    int highBound = 100;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void addValue(int value){
        Assets.Node n = new Assets.Node(value);
        addNode(n, root);
    }

    //Todo should return height
    public int getHeight(){
        return getLevels(root);
    }

    private int getLevels(Node node) {
        if(node == null){
            return 0;
        }
        else if(node.isLeaf()){
            return 1;
        }
        else{
            return 1 + Math.max(getLevels(node.left), getLevels(node.right));
        }

    }

    //Todo should balance the tree
    public void balance(){

    }

    public void addNode(Node newNode, Node parent){
        //Right
        if(newNode.value >= parent.value){
            if(parent.right==null){
                parent.right = newNode;
            }else {
                addNode(newNode, parent.right);
            }
        }
        //Left
        else{
            if(parent.left==null){
                parent.left = newNode;
            }else {
                addNode(newNode, parent.left);
            }
        }
    }

    public BinaryTree(int nbrOfNodes){
        Random random = new Random();

        root = new Node(random.nextInt(highBound));
        for (int i = 0; i < nbrOfNodes; i++) {
           Node node = new Node(random.nextInt(highBound));
           addNode(node, root);
        }

    }

    public void printTree(){
        HashMap<Integer, int[]> treeAsIntMap = generateHashMap(getHeight(), root);
        printTreeAsintMap(treeAsIntMap);
    }

    private String getStringFromTree(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        return null;
    }

    private void printTreeAsintMap(HashMap<Integer,int[]> treeAsIntMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treeAsIntMap.size() ; i++) {
            sb.append("\n");
            sb.append(getBlankSpaces(getLevels(root) * (4) -getLevels(root)*i) );
            for (int j:treeAsIntMap.get(i)) {
                sb.append(j + getBlankSpaces(treeAsIntMap.size()*2 - i*2 + 1+(2-Integer.toString(j).length())));
            }
        }
        System.out.println(sb.toString());

        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < treeAsIntMap.size() ; i++) {
            String firstblanks = getBlankSpaces(getLevels(root) * (4) -getLevels(root)*i);


            sb2.append("\n");
        }

    }

    private HashMap<Integer,int[]> generateHashMap(int height, Node root) {
        //Making the map
        HashMap<Integer, int[]> resultMap = new HashMap<Integer, int[]>();
        for (int i = 0; i < height; i++) {
            resultMap.put(i, new int[(int)Math.pow(2,i)]);
        }

        //Filling the map
        int numberOfValues = (int)Math.pow(2, getHeight()) -1;
        Node[] nodeList = new Node[numberOfValues];
        nodeList[0] = root;
        //Hes making a list, hes checking it twice
        for (int i = 0; i < numberOfValues/2 ; i++) {
            Node tempNode = nodeList[i];
            int index = i*2+1;
            if(tempNode!=null){
                if(tempNode.left!=null){
                    nodeList[index] = tempNode.left;
                }else{
                    nodeList[index] = null;
                }
                if(tempNode.right!=null){
                    nodeList[index+1] = tempNode.right;
                }else {
                    nodeList[index+1] = null;
                }
            }
        }

        // i = 2^key-1 + index
        //Hes filling the map
        int key = 0;
        for (int i = 0; i < numberOfValues; i++) {
            if(i >= Math.pow(2, key+1) - 1){
                key++;
            }
            int index = i - ((int)Math.pow(2, key)-1);
            Node node = nodeList[i];
            int value = node!=null ? node.value : -1;
            resultMap.get(key)[index] = value;
        }

        return resultMap;
    }

    private String getBlankSpaces(int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(" ");
        }
        return sb.toString();
    }


}

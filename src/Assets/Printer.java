package Assets;

import java.util.*;


public class Printer {

    //Tree must be balanced
    public void printTree(Node n) {
        int levels = checkTreeLevel(n);
        Stack<Integer> values = getValuesByLevel(n);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getNSpaces(levels+1));
        stringBuilder.append(values.pop());
        stringBuilder.append("\n");
        for (int i = 1; i <= levels; i+=2) {

            //fixes one level
            stringBuilder.append(getNSpaces(levels-(i-1)));
            stringBuilder.append("/" + getNSpaces(i*2-1) + "\\");
            stringBuilder.append("\n");


            stringBuilder.append(getNSpaces(levels-(i+1)));
            String left;
            String right;
            if(!values.isEmpty()){
                left = values.pop().toString();
            }else{
                left = null;
            }
            if(!values.isEmpty()){
                right = values.pop().toString();
            }else{
                right = null;
            }
            stringBuilder.append(left + getNSpaces((i+1)*2-1) + right);

            stringBuilder.append("\n");

        }
        System.out.println(stringBuilder.toString());
    }

    private Stack<Integer> getValuesByLevel(Node n) {
        Stack<Integer> result = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            n = q.poll();
            result.push(n.value);
            if(n.left != null){
                q.add(n.left);
            }
            if(n.right != null){
                q.add(n.right);
            }
        }

        return result;

    }
    private String getNSpaces(int n){
        StringBuilder str = new StringBuilder();
        for(int i=0; i<n;i++){
            str.append(" ");
        }
        return str.toString();
    }

    private StringBuilder addRowToStringbuilder() {
        return null;
    }

    public int checkTreeLevel(Node n) {

        if (n.left == null && n.right == null) {
            return 0;
        } else {
            if (n.left == null) {
                return 1 + checkTreeLevel(n.right);
            } else if (n.right == null) {
                return 1 + checkTreeLevel(n.left);
            } else {
                return 1 + Math.max(checkTreeLevel(n.left), checkTreeLevel(n.right));
            }
        }

    }
}

package Week43;

public class Problem2 {
    //Coding Problem 2
    public static int[] productOfOthers(int[] nbrs) {
        int[] newNbrs = new int[nbrs.length];
        int sum = nbrs[0];
        for (int i = 1; i < nbrs.length; i++)
            sum *= nbrs[i];
        for (int i = 0; i < nbrs.length; i++) {
            newNbrs[i] = sum / nbrs[i];
            System.out.print(newNbrs[i] + " ");
        }
        return newNbrs;
    }

    public static int[] productOfOthersNoDiv(int[] nbrs) {
        int[] newNbrs = new int[nbrs.length];
        int sum;

        for (int i = 0; i < nbrs.length; i++) {
            sum = 1;
            for (int j = 0; j < nbrs.length; j++) {
                if (j != i) {
                    sum *= nbrs[j];
                }
                newNbrs[i] = sum;
            }
            System.out.print(newNbrs[i] + " ");
        }
        return newNbrs;
    }
}

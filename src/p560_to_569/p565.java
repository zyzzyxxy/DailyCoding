package p560_to_569;

import java.util.Arrays;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Pinterest.
 *
 * Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last index starting at index 0.
 *
 * For example, [2, 0, 1, 0] returns True while [1, 1, 0, 1] returns False.
 *
 */

//Hops you can make, doesnt nessecerily mean you must use all your hops? Then for integers > 1 we need to explore several solution
// (until we find one that works or until we know we cannot reach the end)
public class p565 {
    int[][] testArrays ={
            {1,2,0,1,0,1,1},
            {1,2,2,0,1,1,1},
            {3,0,3,1,0,1,1},
            {3,0,9,9,0,1,1},
            {3,0,2,1,0,1,1},
    };

    public void test(){
        for (int i = 0; i < testArrays.length; i++) {
            boolean canMakeIt = testHops(testArrays[i]);
            System.out.println("array: " + i + " canHop?: " + canMakeIt);
        }

    }

    private boolean testHops(int[] arr) {
        int lastIndex = arr.length-1;
        int counter = 0;
        int value = arr[0];

        if (counter == lastIndex){
            return true;
        }
        if(value==0){
            return false;
        }else if(value==1){
            return testHops(makeSubArray(arr, 1, arr.length));
        }else{
            boolean foundWorkingSolution = false;

            while(value>0){
                if(value< lastIndex){
                    foundWorkingSolution = foundWorkingSolution || testHops(makeSubArray(arr, value, arr.length));
                }
                value--;
            }
            return foundWorkingSolution;
        }
    }



    private <T> T[] makeSubArray(T[] arr, int start, int end) {
        return Arrays.copyOfRange(arr,start,end);
    }
    private int[] makeSubArray(int[] arr, int start, int end) {
        return Arrays.copyOfRange(arr,start,end);
    }


}

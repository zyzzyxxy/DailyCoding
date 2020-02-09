package p1_to_9;

import java.util.ArrayList;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Airbnb.
 * <p>
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
 * <p>
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 * <p>
 * Follow-up: Can you do this in O(N) time and constant space?
 */
public class Problem9 {
    int[] numArray = {2, 4, 6, 2, 5, 9};

    public Problem9() {
        int result = checkLargSumNonAdjNum(numArray);
        System.out.println(result);
    }

    private int checkLargSumNonAdjNum(int[] numArray) {
        int result = 0;
        int tempRes1 = 0;
        int tempRes2 = 0;
        int largest1 = 0;
        int largest2 = 0;
        for (int i = 0; i < numArray.length; i+=2) {
            if (numArray[i] >= 0) {
                tempRes1 += numArray[i];
            }else {
                if(tempRes1>largest1){
                    largest1 = tempRes1;
                }
                tempRes1 = 0;
            }
            if (i + 1 < numArray.length && numArray[i+1] >= 0) {
                tempRes2 += numArray[i+1];
            }else {
                if(tempRes2>largest2){
                    largest2 = tempRes2;
                }
                tempRes2 = 0;
            }
            if(tempRes1>largest1){
                largest1 = tempRes1;
            }
            if(tempRes2>largest2){
                largest2 = tempRes2;
            }

        }
        return (largest1 > largest2) ? largest1 : largest2;
    }

}

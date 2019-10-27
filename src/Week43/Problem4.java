package Week43;

import java.util.Arrays;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Stripe.
 *
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
 *
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 *
 * You can modify the input array in-place.
 */
public class Problem4 {

    public Problem4() {
        int[] arr = {3, 4,-2,-3, 1};
        int[] arr2 = {1, 2, 0};
        System.out.println(findMissingN(arr));
        System.out.println(findMissingN(arr2));
    }
    private int findMissingN(int[] arr){
        Arrays.sort(arr);
        int oldVal = 0;
        int newVal = 0;
        for (int i:arr) {
            if(i>0 && oldVal!=i && oldVal+1 != i)
                return oldVal+1;
            if(i>0)
                oldVal=i;
        }
        return oldVal+1;
    }
}

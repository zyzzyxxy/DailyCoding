package p370_to_379;

import java.util.Arrays;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Facebook.
 * <p>
 * Given a list of integers L, find the maximum length of a sequence of consecutive numbers that can be formed using elements from L.
 * <p>
 * For example, given L = [5, 2, 99, 3, 4, 1, 100], return 5 as we can build a sequence [1, 2, 3, 4, 5] which has length 5.
 */
public class p373 {

    int[] L = {5, 2, 99, 3, 4, 1, 100};

    public p373() {

    }

    public void test() {
        test(L);
    }

    public void test(int[] arr) {
        System.out.println("Consecutive numbers in array: " + Arrays.toString(arr) + " is: " + consecutiveNumbersInArr(arr));
    }

    private int consecutiveNumbersInArr(int[] arr) {
        Arrays.sort(arr);
        if (arr != null) {
            int counter = 0;
            while (true) {
                if (arr.length > counter) {
                    if (arr[counter + 1] == arr[counter] + 1) {
                        counter++;
                    } else {
                        return counter + 1;
                    }

                } else {
                    return counter + 1;
                }
            }

        }
        return -1;
    }
}

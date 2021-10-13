package p370_to_379;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Amazon.
 * <p>
 * Given a sorted array arr of distinct integers, return the lowest index i for which arr[i] == i. Return null if there is no such index.
 * <p>
 * For example, given the array [-5, -3, 2, 3], return 2 since arr[2] == 2. Even though arr[3] == 3, we return 2 since it's the lowest index.
 */

public class p374 {
    int[] arr1 = {1,2,2,3,4,5,6,7};
    int[] arr2 = {-5, -3, 2, 3};
    int[] arr3 = {1,2,3,4,5,6,7};

    public p374() {

    }

    public void test() {
        System.out.println(returnLowestIndexIsEqualToValue(arr1));
        System.out.println(returnLowestIndexIsEqualToValue(arr2));
        System.out.println(returnLowestIndexIsEqualToValue(arr3));
    }

    public int returnLowestIndexIsEqualToValue(int[] arr) {
        int counter = 0;
        for (int i : arr) {
            if (i ==  counter){
                return i;
            }
            counter ++;
        }
        return -1;
    }
}

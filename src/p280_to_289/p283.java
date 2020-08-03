package p280_to_289;

import java.util.ArrayList;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Google.
 * <p>
 * A regular number in mathematics is defined as one which evenly divides some power of 60. Equivalently, we can say that a regular number is one whose only prime divisors are 2, 3, and 5.
 * <p>
 * These numbers have had many applications, from helping ancient Babylonians keep time to tuning instruments according to the diatonic scale.
 * <p>
 * Given an integer N, write a program that returns, in order, the first N regular numbers.
 */

public class p283 {
    public p283() {


    }

    public void test() {
        System.out.println(getRegularNumbersUpToN(4));
        System.out.println(getRegularNumbersUpToN(60));
        System.out.println(getRegularNumbersUpToN(40));
        System.out.println(getRegularNumbersUpToN(5693));
        System.out.println(getRegularNumbersUpToN(10000));
    }

    public ArrayList<Integer> getRegularNumbersUpToN(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < n; i++){
            if(checkIfRegular(i)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean checkIfRegular(int n){
        if(n%2!=0 && n%3!=0  && n%5!=0){
            return false;
        }
        for (int i = 2; i <n ; i++) {
            if(i%2!=0 && i%3!=0 && i%5!=0){
                if(n%i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}

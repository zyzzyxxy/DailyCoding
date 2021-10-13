package p400_to_409;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * This problem was asked by Twitter.
 * <p>
 * A strobogrammatic number is a positive number that appears the same after being rotated 180 degrees.
 * For example, 16891 is strobogrammatic.
 * <p>
 * Create a program that finds all strobogrammatic numbers with N digits.
 */
public class p402 {
    int testInt = 16891;
    public HashMap<Integer, Integer> stroboMap;

    public p402() {
        init();
    }

    public void test() {
        System.out.println(getStroboNbrWithinDigits(5));
    }

    private ArrayList getStroboNbrWithinDigits(int size) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int upperbound = (int) Math.pow(10, size);
        //Not clean soulution, this can be done better and faster only iterating through  map numbers.
        for (int i = 0; i < upperbound; i++) {
            if (isStroboGrammatic(i)){
                result.add(i);
            }
        }
        return result;

    }

    private boolean isStroboGrammatic(int n) {
        int counter = 0;
        int nbrLength = getSizeOfInt(n);
        boolean looping = true;
        while (looping) {
            int firstNbr = getDigit(counter, n);
            int secondNbr = getDigit(nbrLength - counter - 1, n);
            if (stroboMap.containsKey(firstNbr)) {
                if (stroboMap.get(firstNbr) != secondNbr) {
                    return false;
                }
            } else {
                return false;
            }

            if (counter >= nbrLength - counter || (nbrLength % 2 == 1 && counter + 1 >= nbrLength - counter)) {
                looping = false;
            }
            counter++;
        }
        return true;
    }

    private int getSizeOfInt(int n) {
        return String.valueOf(n).length();
    }

    private int getDigit(int place, int n) {

        int nbrOfDigits = String.valueOf(n).length();

        if (place > nbrOfDigits) {
            throw new ArrayIndexOutOfBoundsException("Too large placement");
        }
        double temp = n / Math.pow(10, nbrOfDigits - (place + 1));
        return (int) temp % 10;

    }

    public void init() {
        stroboMap = new HashMap<>();
        stroboMap.put(0, 0);
        stroboMap.put(1, 1);
        stroboMap.put(2, 5);
        stroboMap.put(5, 2);
        stroboMap.put(6, 9);
        stroboMap.put(8, 8);
        stroboMap.put(9, 6);
    }
}

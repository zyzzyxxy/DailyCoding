package p200_to_209;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Palantir.
 * <p>
 * Write a program that checks whether an integer is a palindrome. For example, 121 is a palindrome,
 * as well as 888. 678 is not a palindrome. Do not convert the integer into a string.
 */

public class p202 {

    int[] testCases = {1, 11, 1123, 121, 323, 12451, 65456, 12421,123,321,434,343,33344333};

    public p202() {
        for (int i : testCases) {
            if (i == getInvertedInt(i)) {
                System.out.println(i + " is a palindrom number");
            }
        }

    }

    public int getInvertedInt(int i) {
        int length = String.valueOf(i).length();
        int result = 0;

        for (int j = 0; j < length; j++) {
            result += (i % 10) * Math.pow(10, length - 1-j);
            i = i / 10;
        }

        return result;

    }

}



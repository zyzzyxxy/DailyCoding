package p400_to_409;

import java.util.Random;

/**
 * This problem was asked by Two Sigma.
 *
 * Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability,
 * implement a function c that returns an integer from 1 to 7 (inclusive).
 */

public class p403 {

    public p403() {

    }

    public void test(){
        for (int i = 0; i < 20; i++) {
            System.out.print(rand7() + " ");
        }
    }

    public int rand7(){
        Random random = new Random();
        return random.nextInt(7) +1;
    }
}

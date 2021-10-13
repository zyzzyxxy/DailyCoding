package p440_to_449;

import java.util.ArrayList;
import java.util.Timer;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Google.
 *
 * Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.
 *
 * Do this faster than the naive method of repeated multiplication.
 *
 * For example, pow(2, 10) should return 1024.
 */

public class p447 {

    Timer timer = new Timer();

    int[] testnbrs = {5,76,999,12355};
    int[] testpwrs = {2,0,1,66,123, 99999};

    ArrayList<Integer> answersNaive = new ArrayList<>();
    ArrayList<Integer> answers = new ArrayList<>();

    public p447() {

    }

    public void test() throws InterruptedException {
        long timeBeforeNaive = System.nanoTime();
        for (int nbr: testnbrs) {
            for (int pwr:testpwrs) {
                answersNaive.add(powNaive(nbr,pwr));
            }
        }
        long timeAfterNaive = System.nanoTime();
        long timeNaive = timeAfterNaive-timeBeforeNaive;
        System.out.println("naive: " + timeNaive);

        long timeBefore = System.nanoTime();
        for (int nbr: testnbrs) {
            for (int pwr:testpwrs) {
                int answer = pow(nbr,pwr);
                answers.add(answer);
            }
        }
        long timeAfter = System.nanoTime();
        long time = timeAfter-timeBefore;
        System.out.println("pow: " + time);
        for (int i = 0; i < answers.size(); i++) {
            if(answers.get(i).equals(answersNaive.get(i))){
                System.out.println(String.format("nbr %d good %d : %d", i , answers.get(i), answersNaive.get(i)));
            }else{
                System.out.println(String.format("------ FAIL -------nbr %d bad %d : %d", i , answers.get(i), answersNaive.get(i)));
            }
        }


    }

    public int pow(int nbr, int pwr){
        if(pwr<1){
            return 1;
        }
        if(pwr==1){
            return nbr;
        }
        if(pwr%2 !=0){
            return nbr*pow(nbr, pwr-1);
        }
        return pow(nbr*nbr, pwr/2);
    }
    public int powNaive(int nbr, int pwr){
        int result = nbr;
        if(pwr ==0){
            result = 1;
        }
        for (int i = 0; i < pwr-1; i++) {
            result = result*nbr;
        }
        return result;
    }
}

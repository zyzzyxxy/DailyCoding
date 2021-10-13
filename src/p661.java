import java.util.Arrays;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Netflix.
 *
 * Given a sorted list of integers of length N, determine if an element x is in the list without performing any multiplication, division, or bit-shift operations.
 *
 * Do this in O(log N) time.
 */
import Assets.Printer;
public class p661 {

    Integer[] sortedIntegers;

    public p661(){
        sortedIntegers = getSortedIntegers(50,100);
    }

    private Integer[] getSortedIntegers(int count, int maxValue) {
        Integer[] unsortedArr = new Integer[count];
        for (int i = 0; i < unsortedArr.length; i++) {
            unsortedArr[i] = (int)Math.round(Math.random()*100);
        }
        Arrays.sort(unsortedArr);
        Printer.printArray(unsortedArr);
        return unsortedArr;
    }

    public void test(){

    }


}

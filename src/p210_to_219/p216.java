package p210_to_219;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Facebook.
 * <p>
 * Given a number in Roman numeral format, convert it to decimal.
 * <p>
 * The values of Roman numerals are as follows:
 * <p>
 * {
 * 'M': 1000,
 * 'D': 500,
 * 'C': 100,
 * 'L': 50,
 * 'X': 10,
 * 'V': 5,
 * 'I': 1
 * }
 * In addition, note that the Roman numeral system uses subtractive notation for numbers such as IV and XL.
 * <p>
 * For the input XIV, for instance, you should return 14.
 */

public class p216 {
    char[] romanLetters = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int[] romanValues = {1, 5, 10, 50, 100, 500, 1000};
    HashMap romanValuesMap = new HashMap();

    char[] test1 = {'I', 'V', 'X', 'L', 'C', 'D', 'M'}; //334
    char[] test2 = {'L', 'C', 'D', 'M','I', 'V', 'X'}; //350 + 4
    char[] test3 = {'X','X','X','I','I','I'}; //33

    public p216() {
        for(int i=0;i<romanLetters.length;i++){
            romanValuesMap.put(romanLetters[i],romanValues[i]);
        }
        System.out.println(romanToDecimal(test1));
        System.out.println(romanToDecimal(test2));
        System.out.println(romanToDecimal(test3));

    }

    public int romanToDecimal(char[] romannbr) {

        int lastNumber=0;
        int sum=0;
        for(int i = 0; i < romannbr.length;i++){
            int presentNumber = (int)romanValuesMap.get(romannbr[romannbr.length-1-i]);
           if(lastNumber > presentNumber ){
               sum-= presentNumber;
           }else {
               sum +=presentNumber;
           }
           lastNumber=presentNumber;
        }
        return sum;


    }

}

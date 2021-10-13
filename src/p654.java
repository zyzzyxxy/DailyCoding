import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.security.KeyPair;
import java.util.*;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Amazon.
 *
 * Given a string, find the length of the smallest window that contains every distinct character. Characters may appear more than once in the window.
 *
 * For example, given "jiujitsu", you should return 5, corresponding to the final five letters.
 */

public class p654 {
    static ArrayList<String> words = new ArrayList<>();
    static HashMap<String, String> result = new HashMap<>();


    public p654() throws FileNotFoundException {
    }

    private static void loadWords() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/Assets/Words.txt"));
        while (sc.hasNext()){
            words.add(sc.next());
        }
        System.out.println("Done scanning file " + words.size());
    }

    public static void test() throws FileNotFoundException {
        loadWords();
        for (String word:words) {
            findSmallestSubstringWithDistinctChars(word);
        }
        for (String key:result.keySet()){
            System.out.println(key + " "  + result.get(key));
        }
    }

    private static void findSmallestSubstringWithDistinctChars(String word) {
        Set<Character> charSet = populateCharSet(word);
        boolean done = false;
        int startCounter = 0;
        int endCounter = 0;
        String resultString = "";
        while(!done){
            String subWord = getSubstring(word, startCounter,endCounter);
            if(containsAllChars(subWord, charSet)){
                if(resultString.equals("")||subWord.length()<resultString.length()){
                    resultString = subWord;
                }
                startCounter++;
            }else{
                if(endCounter<word.length()){
                    endCounter++;
                }
                else done=true;
            }
        }
        if(!word.equals(resultString)){
            result.put(word, resultString);
        }

    }

    private static boolean containsAllChars(String subWord, Set<Character> charSet) {
        char[] subW = subWord.toCharArray();
        for (char c:charSet) {
            if(!arrContainsElement(subW, c)){
                return false;
            }
        }
        return true;
    }

    private static boolean arrContainsElement(char[] subW, char c) {
        for (char ch:subW) {
            if(ch==c){
                return true;
            }
        }
        return false;
    }

    private static String getSubstring(String word, int startCounter, int endCounter) {
        return word.substring(startCounter,endCounter);
    }

    private static Set<Character> populateCharSet(String word) {
        Set<Character> tempSet = new HashSet<>();
        for (char c:word.toCharArray()) {
            if(!tempSet.contains(c)){
                tempSet.add(c);
            }
        }
        return tempSet;
    }

}

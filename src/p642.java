import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Pivotal.
 *
 * A step word is formed by taking a given word, adding a letter, and anagramming the result. For example, starting with the word "APPLE", you can add an "A" and anagram to get "APPEAL".
 *
 * Given a dictionary of words and an input word, create a function that returns all valid step words.
 */

import Assets.*;

public class p642 {
    static ArrayList<String> words = new ArrayList<>();
    static ArrayList<String> step_words = new ArrayList<>();

    public  p642() throws IOException {
        ScanWords();
    }

    public static void test(String inputWord) {
        //A stepword will be one length longer than the word
        ArrayList<String> potential_words = getWordsOfLength(inputWord.length()+1);
        getStepWords(potential_words, inputWord);
        System.out.println(step_words);
    }

    private static void getStepWords(ArrayList<String> potential_words, String inputWord) {

        char[] inputChars = inputWord.toCharArray();

        for (String s:potential_words) {
            StringBuilder sb = new StringBuilder(s);
            boolean addWord = true;
            for (char c:inputChars) {
                int indexOf = sb.indexOf(String.valueOf(c));
                if(indexOf != -1){
                    sb.deleteCharAt(indexOf);
                }else{
                    addWord = false;
                }
            }
            if(addWord){
                step_words.add(s);
            }
        }
    }

    private static ArrayList<String> getWordsOfLength(int i) {
        ArrayList<String> result = new ArrayList<>();

        for (String s:words) {
          if(s.length() == i){
              result.add(s);
          }
        }

        return result;
    }

    private void ScanWords() throws IOException {
        String currentPath = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + currentPath);

        Scanner sc = new Scanner(new File("./src/Assets/Words.txt"));
        while (sc.hasNext()){
            words.add(sc.next());
        }
        System.out.println("Done scanning file " + words.size());
    }


}

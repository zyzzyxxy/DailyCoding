package p280_to_289;


import java.util.ArrayList;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Netflix.
 *
 * Given an array of integers, determine whether it contains a Pythagorean triplet. Recall that a Pythogorean triplet (a, b, c) is defined by the equation a2+ b2= c2.
 */
public class p282 {

    public p282(){
    }

    public boolean containsPythagoreanTriplet(int[] arr){
        ArrayList<Integer> squared = new ArrayList();
        for(int i = 0; i < arr.length; i++){
            squared.add(arr[i]*arr[i]);
        }

        for(int i = 0; i< squared.size()-1;i++){
            for(int j = i; j<squared.size();j++){
                if(squared.contains(squared.get(i)+squared.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    public void test() {
        int[] nbrs1 = {1,1,1};
        int[] nbrs2 = {1,2,3};
        int[] nbrs3 = {1,2,5};
        int[] nbrs4 = {2,2,2};
        int[] nbrs5 = {3,4,5};
        assert containsPythagoreanTriplet(nbrs1) ==false;
        assert containsPythagoreanTriplet(nbrs2)== false;
        assert containsPythagoreanTriplet(nbrs3)== false;
        assert containsPythagoreanTriplet(nbrs4)== false;
        assert containsPythagoreanTriplet(nbrs5)== true;
    }
}

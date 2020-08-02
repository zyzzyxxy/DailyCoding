package p280_to_289;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by LinkedIn.
 * <p>
 * A wall consists of several rows of bricks of various integer lengths and uniform height. Your goal is to find a vertical line going from the top to the bottom of the wall that cuts through the fewest number of bricks. If the line goes through the edge between two bricks, this does not count as a cut.
 * <p>
 * For example, suppose the input is as follows, where values in each row represent the lengths of bricks in that row:
 * <p>
 * [[3, 5, 1, 1],
 * [2, 3, 3, 2],
 * [5, 5],
 * [4, 4, 2],
 * [1, 3, 3, 3],
 * [1, 1, 6, 1, 1]]
 * The best we can we do here is to draw a line after the eighth brick, which will only require cutting through the bricks in the third and fifth row.
 * <p>
 * Given an input consisting of brick lengths for each row such as the one above, return the fewest number of bricks that must be cut to create a vertical line.
 */
public class p281 {
    int[][] testarr = {{3, 5, 1, 1},
                        {2, 3, 3, 2},
                        {5, 5},
                        {4, 4, 2},
                        {1, 3, 3, 3},
                        {1, 1, 6, 1, 1}};

    public p281() {

    }

    //I´m drunk writing this, watching senoir say no comment programming is the way to go
    public void testClass() throws Exception {
        int minCuts = countMinimumBrickCounts(testarr);
        System.out.println(minCuts);
    }

    public int countMinimumBrickCounts(int[][] wall) throws Exception {
        HashMap<Integer, Integer> interferences = new HashMap<Integer, Integer>();
        int length = getWallLength(wall);
        for (int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall[i].length; j++) {
                int edge = wall[i][j];
                for (int k = 0; k < length; k++) {
                    if(k<edge){
                        int value = interferences.get(k) != null ? interferences.get(k)+1:1;
                        interferences.put(k,value);
                    }
                    if(k==edge && j < wall[i].length-1){
                        j++;
                        edge += wall[i][j];
                    }
                }
            }
        }
        Iterator<Integer> iterator = interferences.values().iterator();
        int lowest = Integer.MAX_VALUE;
        while (iterator.hasNext()){
            int i = iterator.next();
            if(i<lowest){
                lowest=i;
            }
        }
        return lowest;
    }

    private int getWallLength(int[][] wall) throws Exception {
        int length = 0;
        int new_length = 0;
        for (int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall[i].length; j++) {
                new_length += wall[i][j];
            }
            if (length != new_length && i > 0) {
                throw new Exception("Not consinstent lenght in wall");
            }
            length = new_length;
            new_length = 0;
        }
        return length;
    }

}

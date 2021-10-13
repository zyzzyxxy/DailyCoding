package p400_to_409;

import java.util.ArrayList;
import java.util.Random;

/**
 * This problem was asked by Snapchat.
 * <p>
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 * <p>
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */

public class p404 {

    interval[] intervals = {new interval(), new interval(), new interval(), new interval(), new interval(), new interval(), new interval(), new interval()};

    public p404() {

    }

    public void test() {
        int maxnbr =0;
        ArrayList<interval> maxIntervals = new ArrayList<>();
        printIntervals(intervals);
        //expensive soulution, there is a better algorithm.. i´m tired cant remember it
        //This is bad, not working right, there are cases that this don´´ consider
        for (interval i:intervals) {
            ArrayList<interval> list = new ArrayList<>();
            list.add(i);
            for (interval j:intervals) {
                boolean addToList = true;
                for (interval k:list) {
                    if(!(j.startTime > k.endTime || k.startTime > j.endTime)){
                        addToList = false;
                    }
                }
                if(addToList)
                    list.add(j);
            }
            if(list.size()>maxIntervals.size()){
                maxIntervals=list;
                maxnbr = list.size();
            }
        }
        System.out.println(maxnbr);
        System.out.println(maxIntervals.toString());

    }

    public void printIntervals(interval[] inter){
        for (interval i:inter) {
            System.out.println(i.toString());
        }
    }

    class interval {
        int startTime;
        int endTime;

        int lowBound = 0;
        int highBound = 300;

        int minLectureTime = 30;
        int maxLectureTime = 120;

        public interval() {
            Random random = new Random();
            this.startTime = random.nextInt(highBound - minLectureTime) + 1; //0 - 270
            this.endTime = random.nextInt(maxLectureTime - minLectureTime) + minLectureTime + startTime;
            if (endTime > highBound) {
                endTime = highBound;
            }
        }

        @Override
        public String toString() {
            return "interval{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}

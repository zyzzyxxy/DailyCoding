package p10_to_19;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Apple.
 *
 * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
 */
public class Problem10 {


    public Problem10() throws InterruptedException {
        Function <String, Void> func = e -> {
            System.out.println("Im coming! " + e);
            return null;
        };
        testFunction(1000, func);
    }

    private void testFunction(int n, Function<String, Void> func) throws InterruptedException {
        String name = "Steven";

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                func.apply(name);

            }
            }, (long) 0.01, n);

    }

}

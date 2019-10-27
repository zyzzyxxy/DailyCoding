package Week43;

public class Problem1 {
    //Coding Problem 1
    public static boolean canNumbersAddUp(int[] numbers, int goalNumber) {
        if (numbers.length < 2)
            return false;
        int testNumber = numbers[0];
        int[] newNumbers = new int[numbers.length - 1];
        for (int i = 1; i < numbers.length; i++) {
            if (testNumber + numbers[i] == goalNumber) {
                return true;
            } else {
                newNumbers[i - 1] = numbers[i];
            }
        }

        return canNumbersAddUp(newNumbers, goalNumber);
    }
}


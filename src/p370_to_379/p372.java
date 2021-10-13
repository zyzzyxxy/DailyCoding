package p370_to_379;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Amazon.
 * <p>
 * Write a function that takes a natural number as input and returns the number of digits the input has.
 * <p>
 * Constraint: don't use any loops.
 **/

public class p372 {

    public p372() {

    }

    public void test() throws Exception {
        int[] intArr = {1, 15000, 1932340, -3, 0};

        for (int i : intArr) {
            try {
                System.out.println("digits for " + i + ": " + this.getNumberOfDigits(i));
            } catch (Exception e){
                System.out.println(e.toString() + " when trying out method with number: " + i);
            }

        }
    }

    public int getNumberOfDigits(int n) throws Exception {
        if (checkIfNatural(n)) {
            return Integer.toString(n).length();
        } else {
            throw new Exception("Not a natural number");
        }
    }

    //Since integers can be negative
    private boolean checkIfNatural(int n) {
        if (n >= 0) {
            return true;
        }
        return false;
    }
}

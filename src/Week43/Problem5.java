package Week43;

/**
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Jane Street.
 *
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 *
 * Given this implementation of cons:
 *
 * def cons(a, b):
 *     def pair(f):
 *         return f(a, b)
 *     return pair
 * Implement car and cdr.
 */
public class Problem5 {
    private class Pair{
        Object first;

        public Object getFirst() {
            return first;
        }

        public Object getSecond() {
            return second;
        }

        Object second;

        public Pair(Object first, Object second) {
            this.first = first;
            this.second = second;
        }
    }

    public Problem5() {

        System.out.println( car(cons(3,4)));
        System.out.println( cdr(cons(3,4)));
    }

    private Pair cons(int i, int i1) {
        return new Pair(i,i1);
    }

    private Object cdr(Pair pair) {
        return pair.getSecond();
    }

    private Object car(Pair pair) {
        return pair.getFirst();
    }
}

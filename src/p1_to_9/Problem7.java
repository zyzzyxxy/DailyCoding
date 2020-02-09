package p1_to_9;

/**
 * Good morning! Here's your coding interview problem for today.
 * <p>
 * This problem was asked by Facebook.
 * <p>
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * <p>
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * <p>
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class Problem7 {
    //121234121482
    public Problem7(String message) {
        int nbrOfWays = calcVariations(message);
        System.out.println(nbrOfWays);
    }

    private int calcVariations(String message) {
        if (message.length() == 1) {
            return 1;
        } else {
            int nbr1 = Integer.parseInt(message.substring(0, 1));
            int nbr2 = Integer.parseInt(message.substring(1, 2));
            if (nbr1 <= 2 && nbr1 != 0 && nbr1 <= 6) { // can be interpreted in several ways
                if (message.length() == 2) {
                    return 2;
                }
                return calcVariations(message.substring(1)) + calcVariations(message.substring(2));
            } else {
                return calcVariations(message.substring(1));
            }
        }
    }
}

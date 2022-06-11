package numbers.math;

import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * Author: Faheem Anis
 * Dated: 11/06/2022
 *
 * The class contains functions for performing low level actions on different numbers.
 * It also contains all the utility functions to determine different properties.
 */
public class MathUtils {
    /**
     * Check if a number is a perfect square
     * @param number The number to check
     * @return true if number is perfect square, false otherwise.
     */
    public static boolean isPerfectSquare(long number){
        int x = (int) Math.sqrt(number);
        return Math.pow(x,2) == number;
    }

    /**
     * Check if number contains a digit
     * @param digit Digit to check for
     * @return true if number contains digit, false otherwise
     */
    public static boolean hasDigit(long number, int digit) {
        long clone = number;
        while (clone > 0) {
            if (clone % 10 == digit)
                return true;

            clone = clone / 10;
        }
        return false;
    }

    /**
     * Get the first digit of current number.
     * @return The first digit of current number.
     */
    public static long firstDigit(long number) {
        long x = number;
        while (x > 9) {
            x /= 10;
        }
        return x;
    }

    /**
     * Checks if string can be converted to a number.
     * @param str The string to check
     * @return true if string is numeric, false otherwise
     */
    public static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        return str.length() == pos.getIndex();
    }
}

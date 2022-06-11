package numbers.math.properties;

import numbers.math.MathUtils;
import numbers.math.IProperty;

public class Gapful implements IProperty {
    /**
     * Check if number is gapful
     * @return true if number is gapful, false otherwise.
     */
    @Override
    public boolean isTrue(long number) {
        if (number < 100) {
            return false;
        }
        long firstDigit = MathUtils.firstDigit(number);
        long lastDigit = number % 10;

        int divisor = Integer.parseInt(String.valueOf(firstDigit) + lastDigit);
        return number % divisor == 0;
    }
}

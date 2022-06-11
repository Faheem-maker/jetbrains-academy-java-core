package numbers.math.properties;

import numbers.math.IProperty;

public class Odd implements IProperty {
    /**
     * Check if the number is odd.
     *
     * @return true if number is odd, false otherwise.
     */
    @Override
    public boolean isTrue(long number) {
        return number % 2 != 0;
    }

    @Override
    public String exclusive() {
        return "even";
    }

    @Override
    public String negativeExclusive() {
        return "-even";
    }
}

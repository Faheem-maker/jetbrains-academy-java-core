package numbers.math.properties;

import numbers.math.IProperty;

public class Even implements IProperty {

    @Override
    public String exclusive() {
        return "odd";
    }

    /**
     * Check if the number is even.
     * @return true if the number is even, false otherwise.
     */
    @Override
    public boolean isTrue(long number) {
        return number % 2 == 0;
    }

    @Override
    public String negativeExclusive() {
        return "-odd";
    }
}

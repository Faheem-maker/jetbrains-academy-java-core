package numbers.math.properties;

import numbers.math.IProperty;

public class Buzz  implements IProperty {
    /**
     * Check if the number is a buzz number.
     *
     * A buzz number is one that is divisible by 7 or ends with 7.
     * @return true if number is buzz, false otherwise.
     */
    @Override
    public boolean isTrue(long number) {
        return number % 10 == 7 || number % 7 == 0;
    }
}

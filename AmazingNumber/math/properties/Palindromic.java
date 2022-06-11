package numbers.math.properties;

import numbers.math.IProperty;

public class Palindromic implements IProperty {

    /**
     * Check if number is palindromic
     * @return true if number is palindromic, false otherwise.
     */
    @Override
    public boolean isTrue(long number) {
        String numberStr = String.valueOf(number);
        String reversed = new StringBuilder(numberStr).reverse().toString();

        return numberStr.equals(reversed);
    }
}

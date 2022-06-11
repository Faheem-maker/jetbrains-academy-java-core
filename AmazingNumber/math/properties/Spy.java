package numbers.math.properties;

import numbers.math.IProperty;

public class Spy implements IProperty {
    /**
     * Check if the number is a spy number
     *
     * @return true if number is spy, false otherwise
     */
    @Override
    public boolean isTrue(long number) {
        long sum = 0;
        long product = 1;
        long clone = number;

        while (clone > 0){
            sum += clone % 10;
            product *= clone % 10;
            clone /= 10;
        }
        return sum == product;
    }

    @Override
    public String exclusive() {
        return "duck";
    }
}

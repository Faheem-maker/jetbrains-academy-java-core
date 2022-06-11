package numbers.math.properties;

import numbers.math.IProperty;

public class Happy implements IProperty {
    @Override
    public boolean isTrue(long number) {
        long result = number;

        while (result != 1 && result != 4) {
            result = checkHappyNumber(result);
        }

        return result == 1;
    }

    @Override
    public String exclusive() {
        return "sad";
    }

    public long checkHappyNumber(long number) {
        int rem = 0, sum = 0;
        // calculate the sum of squares of each digit
        while (number > 0) {
            rem = (int) (number % 10);
            sum = sum + (rem * rem);
            number = number / 10;
        }
        return sum;
    }
}

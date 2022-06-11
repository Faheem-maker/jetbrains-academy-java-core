package numbers.math.properties;

import numbers.math.MathUtils;
import numbers.math.IProperty;

public class Duck implements IProperty {
    /**
     * Check if number is duck, (i.e. contains some zeros).
     *
     * @return true if number is duck, false otherwise.
     */
    @Override
    public boolean isTrue(long number) {
        return MathUtils.hasDigit(number, 0);
    }

    @Override
    public String exclusive() {
        return "spy";
    }
}

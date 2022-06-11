package numbers.math.properties;

import numbers.math.MathUtils;
import numbers.math.IProperty;

public class Sunny implements IProperty {
    @Override
    public boolean isTrue(long number) {
        return MathUtils.isPerfectSquare(number + 1);
    }

    @Override
    public String exclusive() {
        return "square";
    }
}

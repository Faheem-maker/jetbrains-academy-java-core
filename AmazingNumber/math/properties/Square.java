package numbers.math.properties;

import numbers.math.MathUtils;
import numbers.math.IProperty;

public class Square implements IProperty {
    @Override
    public boolean isTrue(long number) {
        return MathUtils.isPerfectSquare(number);
    }

    @Override
    public String exclusive() {
        return "square";
    }
}

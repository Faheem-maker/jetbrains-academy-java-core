package numbers.math.properties;

import numbers.math.IProperty;
import numbers.math.Property;

public class Sad implements IProperty {
    @Override
    public boolean isTrue(long number) {
        return !Property.HAPPY.isTrue(number);
    }

    @Override
    public String exclusive() {
        return "happy";
    }
}

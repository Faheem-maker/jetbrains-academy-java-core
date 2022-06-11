package numbers.math;

import numbers.math.properties.*;

public enum Property {
    EVEN(new Even()),
    ODD(new Odd()),
    BUZZ(new Buzz()),
    DUCK(new Duck()),
    PALINDROMIC(new Palindromic()),
    GAPFUL(new Gapful()),
    SPY(new Spy()),
    SQUARE(new Square()),
    SUNNY(new Sunny()),
    HAPPY(new Happy()),
    SAD(new Sad()),
    JUMPING(new Jumping());

    private final IProperty property;

    Property(IProperty property) {
        this.property = property;
    }

    public boolean isTrue(long number) {
        return property.isTrue(number);
    }

    public static Property fromString(String text) {
        for (Property b : Property.values()) {
            if (b.toString().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public static String getList() {
        StringBuilder list = new StringBuilder("[");

        for (Property property :
                Property.values()) {
            list.append(property.toString()).append(", ");
        }

        list.setLength(list.length() - 2);
        list.append("]");
        return list.toString();
    }

    public String exclusive() {
        return property.exclusive();
    }

    public String negativeExclusive() {
        return property.negativeExclusive();
    }
}

package numbers.math;

import java.util.List;
import java.util.Locale;

public class AmazingNumber {
    /**
     * The number to display properties of
     */
    private long number;

    /**
     * Set the number
     * @param number the new number
     */
    public void setNumber(long number) {
        this.number = number;
    }

    public AmazingNumber() {
        number = 0;
    }

    public boolean hasAllProperties(List<Property> properties){
        for (Property property :
                properties) {
            if (!property.isTrue(number)){
                return false;
            }
        }
        return true;
    }

    public boolean notHasAny(List<Property> properties){
        for (Property property :
                properties) {
            if (property.isTrue(number)){
                return false;
            }
        }
        return true;
    }

    /**
     * Display the properties in a single line.
     * @return a string representing the properties of current number.
     */
    public String getPropertiesString() {
        StringBuilder result = new StringBuilder();
        result.append(number);
        result.append(" is ");

        for (Property property :
                Property.values()) {
            if (property.isTrue(number)){
                result.append(property.toString().toLowerCase(Locale.ROOT)).append(", ");
            }
        }

        // Remove trailing commas
        result.setLength(result.length() - 2);

        return result.toString();
    }

    public boolean hasProperty(String property){
        Property propertyTester = Property.fromString(property);
        if (propertyTester == null){
            return false;
        }
        return propertyTester.isTrue(number);
    }
}

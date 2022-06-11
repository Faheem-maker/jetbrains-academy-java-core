package numbers;

import numbers.math.AmazingNumber;
import numbers.math.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class NumbersList {
    private final AmazingNumber propertiesBuilder;

    private List<Property> testers;
    private List<Property> falseTesters;

    public NumbersList(AmazingNumber builder) {
        propertiesBuilder = builder;
    }

    public NumbersList() {
        propertiesBuilder = new AmazingNumber();
    }

    public void displayDigitProperties(long number) {
        // Display properties
        System.out.printf("Properties of %d%n", number);
        for (Property property :
                Property.values()) {
            System.out.printf("%s:\t%s%n", property.toString().toLowerCase(Locale.ROOT), property.isTrue(number));
        }
    }

    /**
     * Display list of properties of numbers from start to end
     *
     * @param start The starting number of list
     * @param end   How many numbers to display
     */
    public void displayList(long start, long end) {
        for (long i = 0; i < end; i++) {
            propertiesBuilder.setNumber(start + i);

            System.out.print("\t");
            System.out.println(propertiesBuilder.getPropertiesString());
        }
    }

    private boolean validateProperties(String... propertyNames){
        List<String> propertyList = List.of(propertyNames);
        testers = new ArrayList<>();
        falseTesters = new ArrayList<>();

        int numInvalids = 0;
        boolean invalid = false;
        StringBuilder error = new StringBuilder("[");

        for (String propertyName :
                propertyNames) {
            boolean negative = propertyName.startsWith("-");
            Property test = Property.fromString(negative ? propertyName.substring(1) : propertyName);
            if (test == null) {
                invalid = true;
                numInvalids++;
                error.append(propertyName).append(", ");
                continue;
            }

            // Test for mutually exclusive properties
            String oppositeProperty = negative ? test.negativeExclusive() : test.exclusive();
            if (!Objects.equals(oppositeProperty, "") && propertyList.contains(oppositeProperty)){
                System.out.printf("The request contains mutually exclusive properties: [%s, %s]%n", propertyName, oppositeProperty);
                System.out.println("There are no numbers with these properties.");
                return false;
            }
            else if (propertyList.contains(negative ? propertyName.substring(1) : "-" + propertyName)){
                System.out.printf("The request contains mutually exclusive properties: [%s, %s]%n", propertyName, "-" + propertyName);
                System.out.println("There are no numbers with these properties.");
                return false;
            }
            if (negative){
                falseTesters.add(test);
            }
            else{
                testers.add(test);
            }
        }

        // Display error message
        if (invalid){
            error.setLength(error.length() - 2);
            error.append("]");
            System.out.printf("The %s %s %s wrong.%n", numInvalids > 1 ? "properties" : "property",
                    error, numInvalids > 1 ? "are" : "is");
            System.out.println("Available properties: " + Property.getList());
            return false;
        }
        return true;
    }

    public void findProperties(long start, long count, String... properties){
        if (!validateProperties(properties)){
            return;
        }

        long i = 0;
        long numbersFound = 0;
        while (numbersFound < count){
            propertiesBuilder.setNumber(i + start);
            if (propertiesBuilder.hasAllProperties(testers) && propertiesBuilder.notHasAny(falseTesters)){
                numbersFound++;
                System.out.print("\t");
                System.out.println(propertiesBuilder.getPropertiesString());
            }
            i++;
        }
    }
}

package numbers.math;

public interface IProperty {
    boolean isTrue(long number);

    /**
     * Return the name of mutually exclusive property (opposite properties).
     * @return name of opposite property, empty string if none
     */
    default String exclusive(){
        return "";
    }

    default String negativeExclusive(){
        return "";
    }
}

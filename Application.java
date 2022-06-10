package numbers;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;
import java.util.Scanner;

public class Application {
    private List<String> args;

    private Scanner scanner;

    private AmazingNumber properties;

    private Application() {

    }

    /**
     * Create a new instance of application
     * @param args The command line arguments
     * @return A new instance of application
     */
    public static Application create(String[] args) {
        Application application = new Application();
        application.args = List.of(args);
        return application;
    }

    /**
     * Display welcome message and instructions to user
     */
    public void welcome() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }

    /**
     * Process the user input as appropriate
     */
    public void processInput(String input) {
        if (isNumeric(input)) {
            // If input a single natural number
            long number = Long.parseLong(input);
            // Make sure that it is natural
            if (number <= 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                return;
            }
            displayProperties(number);
            return;
        }
        // Display properties of a list of numbers
        String[] numbers = input.split(" ");
        // Make sure that input is formatted correctly
        if (numbers.length != 2) {
            System.out.println("Invalid format.");
            return;
        }
        long start = assertNatural(numbers[0], "The first parameter should be a natural number or zero.");
        long end = assertNatural(numbers[1], "The second parameter should be a natural number.");
        if (start == 0 || end == 0) {
            return;
        }
        displayList(start, end);
    }

    /**
     * Display list of properties of numbers from start to end
     * @param start The starting number of list
     * @param end How many numbers to display
     */
    public void displayList(long start, long end) {
        for (long i = 0; i < end; i++) {
            properties.setNumber(start + i);

            System.out.println(properties.getPropertiesString());
        }
        System.out.println();
    }

    /**
     * Display an error message if the string cannot be converted to a natural number,
     * @param input The string to check
     * @param error The error message
     * @return passed input as number if number is natural, 0 otherwise
     */
    public long assertNatural(String input, String error) {
        if (!isNumeric(input)) {
            System.out.println(error);
            return 0;
        }
        long number = Long.parseLong(input);
        if (number <= 0) {
            System.out.println(error);
            return 0;
        }
        return number;
    }

    /**
     * Display properties of a single number
     * @param number The number to display
     */
    private void displayProperties(long number) {
        // Display properties
        properties.setNumber(number);
        System.out.printf("Properties of %d%n", number);
        System.out.printf("even:\t%s%n", properties.isEven());
        System.out.printf("odd:\t%s%n", properties.isOdd());
        System.out.printf("buzz:\t%s%n", properties.isBuzz());
        System.out.printf("duck:\t%s%n", properties.isDuck());
        System.out.printf("palindromic:\t%s%n", properties.isPalindromic());
        System.out.printf("gapful:\t%s%n", properties.isGapful());
        System.out.println();
    }

    /**
     * Checks if string can be converted to a number.
     * @param str The string to check
     * @return true if string is numeric, false otherwise
     */
    public static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        return str.length() == pos.getIndex();
    }

    /**
     * Run the application.
     *
     * It will perform the following actions
     *
     * 1) Ask user for an input
     * 2) Display an error message is input is incorrect
     * 3) Exit if input is 0
     * 4) Display properties
     */
    public void run() {
        scanner = new Scanner(System.in);
        welcome();


        // Start the cycle
        long number;
        properties = new AmazingNumber();
        String exit = "0";

        while (true) {
            System.out.print("Enter a request: ");
            String input = scanner.nextLine();
            System.out.println();

            if (input.equals(exit)) {
                break;
            }

            processInput(input);
        }
    }
}

package numbers;

import numbers.math.MathUtils;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private List<String> args;

    private NumbersList outputController;

    public InputHandler inputHandler;

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
        application.outputController = new NumbersList();
        application.inputHandler = new InputHandler();
        return application;
    }

    /**
     * Process the user input as appropriate
     */
    public void processInput(String input) {
        if (MathUtils.isNumeric(input)) {
            handleSingleInput(input);
            return;
        }
        // Display properties of a list of numbers
        String[] numbers = input.split(" ");
        // Make sure that input is formatted correctly
        if (numbers.length >= 3){
            findProperty(numbers);
            return;
        }
        if (numbers.length != 2) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;
        }
        long start = assertNatural(numbers[0], "The first parameter should be a natural number or zero.");
        long end = assertNatural(numbers[1], "The second parameter should be a natural number.");
        if (start == 0 || end == 0) {
            return;
        }
        outputController.displayList(start, end);
    }

    public void findProperty(String[] input){
        long num1 = assertNatural(input[0], "The first parameter should be a natural number or zero.");
        long num2 = assertNatural(input[1], "The second parameter should be a natural number.");

        if (num1 == 0 || num2 == 0){
            return;
        }
        if (input.length == 3){
            outputController.findProperties(num1, num2, input[2]);
        }
        else{
            outputController.findProperties(num1, num2, Arrays.copyOfRange(input, 2, input.length));
        }
    }

    public void handleSingleInput(String input){
        // If input a single natural number
        long number = Long.parseLong(input);
        // Make sure that it is natural
        if (number <= 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;
        }
        displayProperties(number);
    }

    /**
     * Display an error message if the string cannot be converted to a natural number,
     * @param input The string to check
     * @param error The error message
     * @return passed input as number if number is natural, 0 otherwise
     */
    public long assertNatural(String input, String error) {
        if (!MathUtils.isNumeric(input)) {
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
        outputController.displayDigitProperties(number);
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
        Scanner scanner = new Scanner(System.in);
        inputHandler.welcome();

        // Start the cycle
        String exit = "0";

        while (true) {
            String input = inputHandler.request();
            System.out.println();
            if (input.equals(exit)){
                break;
            }

            processInput(input);
            System.out.println();
        }
    }
}

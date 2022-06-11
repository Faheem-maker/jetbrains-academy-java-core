package numbers;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(){
        scanner = new Scanner(System.in);
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
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }

    public String request(){
        System.out.print("Enter a request: ");
        return scanner.nextLine();
    }
}

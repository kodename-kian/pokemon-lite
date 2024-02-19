package ui;

import ui.exceptions.BadInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

// UI Tool which handles reading input & verifying validity of input via exceptions
public class InputTool {
    private final Scanner input;

    // EFFECTS: constructs the input scanner
    public InputTool() {
        input = new Scanner(System.in);
    }

    // EFFECTS: returns input if input is valid (is an integer between lower and upper, inclusive)
    //          otherwise throws a BadInputException
    public int getInputInt(String prompt, int lower, int upper) throws BadInputException {
        System.out.print(prompt);

        int returnValue;
        try {
            returnValue = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            input.nextLine();
            throw new BadInputException();
        }

        if (returnValue < lower || returnValue > upper) {
            throw new BadInputException();
        }

        return returnValue;
    }

    // EFFECTS: returns an input String, or "" if no input is read
    public String getInputString(String prompt) {
        System.out.print(prompt);
        String value = input.nextLine();
        if (value.isEmpty() || value == null) {
            value = "";
        }
        return value;
    }
}

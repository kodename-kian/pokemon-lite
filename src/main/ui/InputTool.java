package ui;

import ui.exceptions.BadInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputTool {
    private final Scanner input;

    public InputTool() {
        input = new Scanner(System.in);
    }

    public int getInputInt(String prompt, int lower, int upper) throws BadInputException {
        System.out.print(prompt);

        int returnValue;
        try {
            returnValue = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            input.reset();
            input.next();
            throw new BadInputException();
        }

        if (returnValue < lower || returnValue > upper) {
            throw new BadInputException();
        }

        return returnValue;
    }

    public String getInputString(String prompt) {
        System.out.print(prompt);
        String value = input.nextLine();
        if (value.isEmpty() || value == null) {
            value = "";
        }
        return value;
    }
}

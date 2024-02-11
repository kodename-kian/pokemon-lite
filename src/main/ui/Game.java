package ui;

import java.util.Scanner;

public class Game {
    private static final String header =    "========= POKEMON LITE =========";
    private static final String encounter = "=========  ENCOUNTER   =========";
    private static final String team =      "=========   MY TEAM    =========";
    private static final String pokemon =   "=========  MY POKEMON  =========";

    private final Scanner input;
    private String status;

    public Game() {
        input = new Scanner(System.in);
        status = "";
    }

    // INPUT METHODS
    private int getInputInt() {
        System.out.print("Enter the number of your choice: ");
        return input.nextInt();
    }

    private String getInputString() {
        System.out.print("Enter string: ");
        return input.next();
    }

    // OUTPUT METHODS
    private void printTeamInfo() {
        System.out.println("My team of Pokemon!");
        System.out.println("[POKEMON WILL GO HERE]");
        System.out.println();
    }

    private void printPokemonInfo() {
        System.out.println("Currently viewing: [POKEMON]");
        System.out.println();
    }

    // TEMPORARY METHODS FOR CONSOLE USE
    private void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    private void flushStatus() {
        if (!status.equals("")) {
            System.out.println(status);
            status = "";
        }
    }

    // PRIMARY METHODS
    private void encounter() {
        clearScreen();
        flushStatus();

        System.out.println(header);
        System.out.println(encounter);
        System.out.println("You've encountered a wild [POKEMON]!");
        System.out.println("Select an option:");
        System.out.println("1. Catch Pokemon");
        System.out.println("2. Flee");

        int choice = getInputInt();

        if (choice == 1) {
            status = "CATCH FAILED!";
        } else if (choice == 2) {
            status = "YOU'VE SUCCESSFULLY FLED!";
            return;
        }

        encounter();
    }

    private void pokemonMenu() {
        clearScreen();
        flushStatus();

        System.out.println(header);
        System.out.println(pokemon);

        printPokemonInfo();

        System.out.println("Select an option:");
        System.out.println("1. Rename Pokemon");
        System.out.println("2. Teach Pokemon New Move");
        System.out.println("3. Return to Team Menu");

        int choice = getInputInt();

        if (choice == 1) {
            String newName = getInputString();
            status = "POKEMON RENAMED TO " + newName;
        } else if (choice == 2) {
            status = "POKEMON HAS LEARNED NEW MOVE";
        } else if (choice == 3) {
            status = "RETURNED TO MAIN MENU";
            return;
        }

        pokemonMenu();
    }

    private void teamMenu() {
        clearScreen();
        flushStatus();

        System.out.println(header);
        System.out.println(team);

        printTeamInfo();

        System.out.println("Select an option:");
        System.out.println("1. Edit Pokemon");
        System.out.println("2. Release Pokemon");
        System.out.println("3. Return to Main Menu");

        int choice = getInputInt();

        if (choice == 3) {
            status = "Successfully returned to main menu.";
            return;
        } else {
            System.out.println("Select a Pokemon:");
            int index = getInputInt();

            if (choice == 1) {
                pokemonMenu();
            } else if (choice == 2) {
                status = "[POKEMON WILL BE REMOVED]";
            }
        }

        teamMenu();
    }

    public void play() {
        clearScreen();
        flushStatus();

        System.out.println(header);
        System.out.println("Select an option:");
        System.out.println("1. Encounter a new Pokemon");
        System.out.println("2. Open team menu");
        System.out.println("3. Exit game");

        int choice = getInputInt();

        if (choice == 1) {
            encounter();
        } else if (choice == 2) {
            teamMenu();
        } else if (choice == 3) {
            return;
        }

        play();
    }
}
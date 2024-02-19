package ui;

import model.*;
import ui.exceptions.BadInputException;

import java.io.IOException;

// Primary class to run the game
// Specifics of input & output handling abstracted to helper classes
public class Game {

    private String status;
    private final UITool ui;
    private final InputTool input;

    private final Team team;
    private final Generator generator;

    // EFFECTS: initializes all the required fields
    public Game() {
        input = new InputTool();
        ui = new UITool(this);
        status = "";

        team = new Team();
        try {
            generator = new Generator("generation1");
        } catch (IOException e) {
            throw new RuntimeException(e); //should never happen!
        }
    }

    // EFFECTS: getter for status
    public String getStatus() {
        return status;
    }

    // EFFECTS: setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // EFFECTS: facilitates encounter with a wild Pokemon
    private void encounter(Pokemon p) {

        ui.printEncounterUI(p);

        int choice = 0;

        try {
            choice = input.getInputInt("Enter the number of your choice: ", 1, 2);
        } catch (BadInputException e) {
            setStatus("Something's wrong with your input! Please try again.");
            encounter(p);
        }

        if (choice == 1) {
            team.addPokemon(p.capture());
            status = "SUCCESSFULLY CAUGHT " + p.getDisplayName() + "!";
        } else if (choice == 2) {
            status = "YOU'VE SUCCESSFULLY FLED!";
        }
    }

    private void pokemonMenu(CapturedPokemon p) {

        ui.printPokemonMenuUI(p);

        int choice = 0;

        try {
            choice = input.getInputInt("Enter the number of your choice: ", 1, 3);
        } catch (BadInputException e) {
            setStatus("Something's wrong with your input! Please try again.");
            pokemonMenu(p);
        }

        if (choice == 1) {
            String newName = input.getInputString("Enter a new nickname: ");
            status = "POKEMON RENAMED TO " + newName;
            p.setNickname(newName);
        } else if (choice == 2) {
            status = "POKEMON HAS LEARNED NEW MOVE";
            p.learnMove(generator.generateMove());
        } else if (choice == 3) {
            status = "RETURNED TO MAIN MENU";
        }

    }

    // EFFECTS: facilitates the usage of the Pokemon Team Menu
    private void teamMenu() {

        ui.printTeamMenuUI(team);

        int choice = 0;

        try {
            choice = input.getInputInt("Enter the number of your choice: ", 1, 3);
        } catch (BadInputException e) {
            setStatus("Something's wrong with your input! Please try again.");
            teamMenu();
        }

        if (choice == 3) {
            status = "Successfully returned to main menu.";
        } else {
            editOrReleaseMenu(choice);
            teamMenu();
        }
    }

    // EFFECTS: facilitates the edit & release sub-options of the Pokemon Team Menu
    //          separated from the main menu function due to checkstyle line limits
    private void editOrReleaseMenu(int choice) {

        int index = 0;

        try {
            index = input.getInputInt("Select the number of a Pokemon: ", 1, team.getTeamSize());
        } catch (BadInputException e) {
            setStatus("Something's wrong with your input! Please try again.");
            return;
        }

        if (choice == 1) {
            pokemonMenu(team.getPokemon(index - 1));
        } else if (choice == 2) {
            status = team.getDisplayNames().get(index - 1) + " has been released from the team!";
            team.removePokemon(index - 1);
        }
    }

    // EFFECTS: facilitates the primary gameplay loop
    public void play() {

        ui.printMainUI();

        int choice = 0;

        try {
            choice = input.getInputInt("Enter the number of your choice: ", 1, 3);
        } catch (BadInputException e) {
            setStatus("Something's wrong with your input! Please try again.");
            play();
        }

        if (choice == 1) {
            encounter(generator.generatePokemon());
        } else if (choice == 2) {
            teamMenu();
        } else if (choice == 3) {
            return;
        }

        play();
    }
}
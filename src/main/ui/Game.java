package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.exceptions.BadInputException;

import java.io.FileNotFoundException;
import java.io.IOException;

// Primary class to run the game
// Specifics of input & output handling abstracted to helper classes
public class Game {

    private static final String SAVE_ADDRESS = "./data/myTeam.json";

    private String status;
    private final UITool ui;
    private final InputTool input;

    private Team team;
    private final Generator generator;

    private JsonWriter writer;
    private JsonReader reader;

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

        writer = new JsonWriter(SAVE_ADDRESS);
        reader = new JsonReader(SAVE_ADDRESS);
    }

    // EFFECTS: getter for status
    public String getStatus() {
        return status;
    }

    // EFFECTS: setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // MODIFIES: this
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
            status = "Successfully caught " + p.getDisplayName() + "!";
        } else if (choice == 2) {
            status = "You've successfully fled!";
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
            p.setNickname(newName);
            status = "Pokemon name successfully updated: " + p.getDisplayName();
        } else if (choice == 2) {
            Move newMove = generator.generateMove();
            p.learnMove(newMove);
            status = "Move successfully learned: " + newMove.getDisplayName();
        } else if (choice == 3) {
            status = "Returned to Main Menu!";
        }

    }

    // EFFECTS: facilitates the usage of the Pokemon Team Menu
    private void teamMenu() {

        boolean loopTeamMenu = true;

        while (loopTeamMenu) {
            ui.printTeamMenuUI(team);

            int choice = 0;

            try {
                choice = input.getInputInt("Enter the number of your choice: ", 1, 3);
            } catch (BadInputException e) {
                setStatus("Something's wrong with your input! Please try again.");
                continue;
            }

            if (choice == 3) {
                loopTeamMenu = false;
                status = "Successfully returned to main menu.";
            } else {
                editOrReleaseMenu(choice);
            }
        }
    }

    // MODIFIES: this
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
            status = team.getDisplayNames().get(index - 1) + " has been released from the team.";
            team.removePokemon(index - 1);
        }
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // EFFECTS: saves this.team to file
    private void saveTeam() {
        try {
            writer.open();
            writer.write(this.team);
            writer.close();
            setStatus("Game successfully saved to " + SAVE_ADDRESS);
        } catch (FileNotFoundException e) {
            setStatus("Something went wrong! Unable to save game at " + SAVE_ADDRESS);
        }
    }

    // Referenced from the JsonSerialization Demo
    // https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads team into this.team from file
    private void loadTeam() {
        try {
            this.team = reader.read();
            setStatus("Save successfully loaded from " + SAVE_ADDRESS);
        } catch (IOException e) {
            setStatus("Something went wrong! Unable to load game from " + SAVE_ADDRESS);
        }
    }

    // EFFECTS: facilitates the primary gameplay loop
    public void play() {

        boolean loopGame = true;

        while (loopGame) {
            ui.printMainUI();

            int choice = 0;

            try {
                choice = input.getInputInt("Enter the number of your choice: ", 1, 5);
            } catch (BadInputException e) {
                setStatus("Something's wrong with your input! Please try again.");
                continue;
            }

            if (choice == 1) {
                encounter(generator.generatePokemon());
            } else if (choice == 2) {
                teamMenu();
            } else if (choice == 3) {
                saveTeam();
            } else if (choice == 4) {
                loadTeam();
            } else if (choice == 5) {
                loopGame = false;
            }

        }
    }
}
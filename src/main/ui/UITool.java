package ui;

import model.*;

import java.util.List;

// UI Tool which handles printing of console information, instructions, and ui
public class UITool {

    private static final String HEADER =    "========= POKEMON LITE =========";
    private static final String ENCOUNTER = "=========  ENCOUNTER   =========";
    private static final String TEAM =      "=========   MY TEAM    =========";
    private static final String POKEMON =   "=========  MY POKEMON  =========";

    private final Game game;

    public UITool(Game g) {
        this.game = g;
    }

    // TEMPORARY METHOD FOR CONSOLE USE
    // EFFECTS: "clears" screen by printing several empty lines
    private void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    // TEMPORARY METHOD FOR CONSOLE USE
    // EFFECTS: prints game.getStatus() and clears the value
    private void flushStatus() {
        String status = game.getStatus();
        if (!status.equals("")) {
            System.out.println(status);
            game.setStatus("");
        }
    }

    // EFFECTS: lists all the Pokemon in the team,
    //          or reports that team is empty
    private void printTeamInfo(Team team) {

        if (team.getTeamSize() == 0) {
            System.out.println("Team is currently empty!");
        } else {
            System.out.println("My team of Pokemon!");

            List<String> displayNames = team.getDisplayNames();
            for (int i = 0; i < team.getTeamSize(); i++) {
                System.out.println((i + 1) + ". " + displayNames.get(i));
            }
        }

        System.out.println();
    }

    // EFFECTS: displays name, type, and moves of Pokemon on team
    private void printPokemonInfo(CapturedPokemon p) {
        System.out.println("Currently viewing: " + p.getDisplayName());
        System.out.println("Type: " + p.getType());

        System.out.println("Moves:");
        List<String> moveNames = p.getMoveNames();
        for (int i = 0; i < p.getNumMoves(); i++) {
            System.out.println((i + 1) + ". " + moveNames.get(i));
        }
        System.out.println();
    }

    // EFFECTS: prints the console menu ui for a wild Pokemon encounter
    public void printEncounterUI(Pokemon p) {
        clearScreen();
        flushStatus();

        System.out.println(HEADER);
        System.out.println(ENCOUNTER);
        System.out.println("You've encountered a wild " + p.getDisplayName() + "!");
        System.out.println("Select an option:");
        System.out.println("1. Catch Pokemon");
        System.out.println("2. Flee");
    }

    // EFFECTS: prints the console menu ui for viewing a Pokemon on the team
    public void printPokemonMenuUI(CapturedPokemon p) {
        clearScreen();
        flushStatus();

        System.out.println(HEADER);
        System.out.println(POKEMON);

        printPokemonInfo(p);

        System.out.println("Select an option:");
        System.out.println("1. Rename Pokemon");
        System.out.println("2. Teach Pokemon New Move");
        System.out.println("3. Return to Team Menu");
    }

    // EFFECTS: prints the console menu ui for viewing Team of Pokemon
    public void printTeamMenuUI(Team team) {
        clearScreen();
        flushStatus();

        System.out.println(HEADER);
        System.out.println(TEAM);

        printTeamInfo(team);

        System.out.println("Select an option:");
        System.out.println("1. Edit Pokemon");
        System.out.println("2. Release Pokemon");
        System.out.println("3. Return to Main Menu");
    }

    // EFFECTS: prints the console menu ui for the Main Menu of the game
    public void printMainUI() {
        clearScreen();
        flushStatus();

        System.out.println(HEADER);
        System.out.println("Select an option:");
        System.out.println("1. Encounter a new Pokemon");
        System.out.println("2. Open Team menu");
        System.out.println("3. Save Game");
        System.out.println("4. Load Game");
        System.out.println("5. Exit game");
    }
}

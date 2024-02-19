package ui;

import model.*;

import java.util.List;

public class UITool {

    private static final String HEADER =    "========= POKEMON LITE =========";
    private static final String ENCOUNTER = "=========  ENCOUNTER   =========";
    private static final String TEAM =      "=========   MY TEAM    =========";
    private static final String POKEMON =   "=========  MY POKEMON  =========";

    private final Game game;

    public UITool(Game g) {
        this.game = g;
    }

    // TEMPORARY METHODS FOR CONSOLE USE
    private void clearScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    private void flushStatus() {
        String status = game.getStatus();
        if (!status.equals("")) {
            System.out.println(status);
            game.setStatus("");
        }
    }

    // OUTPUT METHODS
    private void printTeamInfo(Team team) {
        System.out.println("My team of Pokemon!");

        List<String> displayNames = team.getDisplayNames();
        for (int i = 0; i < team.getTeamSize(); i++) {
            System.out.println((i + 1) + ". " + displayNames.get(i));
        }

        System.out.println();
    }

    private void printPokemonInfo(CapturedPokemon p) {
        System.out.println("Currently viewing: " + p.getDisplayName());
        System.out.println("Type: " + p.getType());

        System.out.println("Moves:");
        List<String> moveNames = p.getMoveNames();
        for (int i = 0; i < p.getNumMoves(); i++) {
            System.out.println(i + "." + moveNames.get(i));
        }
        System.out.println();
    }


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

    public void printMainUI() {
        clearScreen();
        flushStatus();

        System.out.println(HEADER);
        System.out.println("Select an option:");
        System.out.println("1. Encounter a new Pokemon");
        System.out.println("2. Open TEAM menu");
        System.out.println("3. Exit game");
    }
}

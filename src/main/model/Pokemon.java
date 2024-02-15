package model;

import java.util.ArrayList;
import java.util.List;

// represents a Pokemon with a species, type, health, and list of moves
public class Pokemon {

    // EFFECTS: constructs a Pokemon with specified species, type, health
    //          initializes empty array of moves
    public Pokemon(String species, String type) {
        // stub
    }

    // EFFECTS: returns species of Pokemon for display
    public String getDisplayName() {
        return "";
    }

    public String getType() {
        return ""; //stub
    }

    // EFFECTS: returns an array of display names for all moves of Pokemon
    public List<String> getMoveNames() {
        return new ArrayList<String>();
    }

    // EFFECTS: returns number of moves in moves array
    public int getNumMoves() {
        return 0; //stub
    }

    // REQUIRES: 0 <= index < getNumMoves()
    // EFFECTS: returns the Move at given index
    public Move getMove(int index) {
        return new Move("", "");
    }

    // MODIFIES: this
    // EFFECTS: adds move to list of moves
    public void learnMove(Move m){

    }

    // EFFECTS: returns a new CapturedPokemon object
    //          with the same attributes as this Pokemon
    public CapturedPokemon capture() {
        return new CapturedPokemon("", "");
    }

}

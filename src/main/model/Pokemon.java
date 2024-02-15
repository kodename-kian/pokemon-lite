package model;

import java.util.ArrayList;
import java.util.List;

// represents a Pokemon with a species, type, health, and list of moves
public class Pokemon {

    private String species;
    private String type;
    private List<Move> moves;

    // EFFECTS: constructs a Pokemon with specified species, type, health
    //          initializes empty array of moves
    public Pokemon(String species, String type) {
        this.species = species;
        this.type = type;
        this.moves = new ArrayList<Move>();
    }

    // EFFECTS: returns species of Pokemon for display
    public String getDisplayName() {
        return this.species;
    }

    public String getType() {
        return this.type;
    }

    // EFFECTS: returns an array of display names for all moves of Pokemon
    public List<String> getMoveNames() {
        List<String> moveNames = new ArrayList<String>();
        for (Move m : this.moves) {
            moveNames.add(m.getDisplayName());
        }
        return moveNames;
    }

    // EFFECTS: returns number of moves in moves array
    public int getNumMoves() {
        return this.moves.size();
    }

    // REQUIRES: 0 <= index < getNumMoves()
    // EFFECTS: returns the Move at given index
    public Move getMove(int index) {
        return this.moves.get(index);
    }

    // MODIFIES: this
    // EFFECTS: adds move to list of moves
    public void learnMove(Move m) {
        this.moves.add(m);
    }

    // EFFECTS: returns a new CapturedPokemon object
    //          with the same attributes as this Pokemon
    public CapturedPokemon capture() {
        CapturedPokemon cp = new CapturedPokemon(this.species, this.type);
        for (Move m : this.moves) {
            cp.learnMove(m);
        }
        return cp;
    }

}

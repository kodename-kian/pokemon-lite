package model;

import java.util.ArrayList;
import java.util.List;

// represents a team of Pokemon
public class Team {

    // EFFECTS: creates an empty array of Pokemon
    public Team() {

    }

    // MODIFIES: this
    // EFFECTS: adds a Pokemon to team
    public void addPokemon(CapturedPokemon p) {
        // stub
    }

    // REQUIRES: index < getTeamSize()
    // MODIFIES: this
    // EFFECTS: removes a Pokemon from team given index
    public void removePokemon(int index) {
        // stub
    }

    public CapturedPokemon getPokemon(int index) {
        return new CapturedPokemon("", "");
    }

    // EFFECTS: returns an array of display names for all Pokemon in team
    public List<String> getDisplayNames() {
        return new ArrayList<String>();
    }

    // EFFECTS: returns size of team
    public int getTeamSize() {
        return 0;
    }
}

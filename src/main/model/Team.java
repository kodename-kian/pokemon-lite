package model;

import java.util.ArrayList;
import java.util.List;

// represents a team of Pokemon
public class Team {

    private List<CapturedPokemon> team;

    // EFFECTS: creates an empty array of Pokemon
    public Team() {
        team = new ArrayList<CapturedPokemon>();
    }

    // MODIFIES: this
    // EFFECTS: adds a Pokemon to team
    public void addPokemon(CapturedPokemon p) {
        team.add(p);
    }

    // REQUIRES: index < getTeamSize()
    // MODIFIES: this
    // EFFECTS: removes a Pokemon from team given index
    public void removePokemon(int index) {
        team.remove(index);
    }

    public CapturedPokemon getPokemon(int index) {
        return team.get(index);
    }

    // EFFECTS: returns an array of display names for all Pokemon in team
    public List<String> getDisplayNames() {
        List<String> displayNames = new ArrayList<String>();
        for (CapturedPokemon p : team) {
            displayNames.add(p.getDisplayName());
        }
        return displayNames;
    }

    // EFFECTS: returns size of team
    public int getTeamSize() {
        return team.size();
    }
}

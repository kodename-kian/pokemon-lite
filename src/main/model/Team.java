package model;

import model.phase4.Event;
import model.phase4.EventLog;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// Represents a team of Pokemon
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
        EventLog.getInstance().logEvent(new Event(p.getDisplayName() + " has joined the team!"));
    }

    // REQUIRES: index < getTeamSize() : input sanitized in ui to satisfy requirement
    // MODIFIES: this
    // EFFECTS: removes a Pokemon from team given index
    public void removePokemon(int index) {
        CapturedPokemon temp = team.get(index);
        team.remove(index);
        EventLog.getInstance().logEvent(new Event(temp.getDisplayName() + " has been set free!"));
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

    // EFFECTS: creates a JSON object which stores all information about the Team
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        JSONArray jsonArray = new JSONArray();

        for (CapturedPokemon pokemon : team) {
            jsonArray.put(pokemon.toJson());
        }

        json.put("team", jsonArray);

        return json;
    }
}

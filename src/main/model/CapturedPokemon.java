package model;

import model.phase4.Event;
import model.phase4.EventLog;
import org.json.JSONArray;
import org.json.JSONObject;

// Represents a Pokemon that belongs to a player's team
public class CapturedPokemon extends Pokemon {

    private String nickname;

    // EFFECTS: creates a captured Pokemon with specified species and type
    public CapturedPokemon(String species, String type) {
        super(species, type);
        this.nickname = "";
    }

    // EFFECTS: returns nickname of captured Pokemon
    public String getNickname() {
        return this.nickname;
    }

    // MODIFIES: this
    // EFFECTS: sets a nickname for Pokemon
    public void setNickname(String s) {
        String oldName = this.getDisplayName();
        this.nickname = s;
        String newName = this.getDisplayName();

        EventLog.getInstance().logEvent(new Event(oldName + " has been renamed to " + newName + "!"));
    }

    // EFFECTS: returns combined String of nickname and species
    //          nickname = "" means that no nickname is currently set
    @Override
    public String getDisplayName() {
        if (this.nickname.equals("")) {
            return super.getDisplayName();
        } else {
            return this.nickname + " (" + super.getDisplayName() + ")";
        }
    }

    // EFFECTS: creates a JSON object which stores all information about the Captured Pokemon
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("species", this.species);
        json.put("type", getType());
        json.put("nickname", this.nickname);
        json.put("moves", movesToJson());
        return json;
    }

    // EFFECTS: returns Moves of CapturedPokemon as a JSON array
    private JSONArray movesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (int index = 0; index < getNumMoves(); index++) {
            jsonArray.put(getMove(index).toJson());
        }

        return jsonArray;
    }
}

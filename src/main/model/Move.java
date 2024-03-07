package model;

import org.json.JSONObject;

// Represents a move a Pokemon can have, with a type and an attack
public class Move {

    private String type;
    private String attack;

    // EFFECTS: constructs a move with specified type and attack
    public Move(String type, String attack) {
        this.type = type;
        this.attack = attack;
    }

    // EFFECTS: returns a combined String of type and attack
    public String getDisplayName() {
        return this.type + " " + this.attack;
    }

    // EFFECTS: returns true if both moves have the same display name
    //          false otherwise
    public boolean isEqual(Move m) {
        return (this.getDisplayName().equals(m.getDisplayName()));
    }

    // EFFECTS: creates a JSON object which stores all information about the Move
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("type", this.type);
        json.put("attack", this.attack);

        return json;
    }
}

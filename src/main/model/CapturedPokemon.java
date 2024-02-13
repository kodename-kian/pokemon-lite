package model;

public class CapturedPokemon extends Pokemon {

    // EFFECTS: creates a captured Pokemon with specified species and type
    public CapturedPokemon(String species, String type) {
        super(species, type);
    }

    // MODIFIES: this
    // EFFECTS: sets a nickname for Pokemon
    public void setNickname(String s) {
        //stub
    }

    // EFFECTS: returns combined String of nickname and species
    @Override
    public String getDisplayName() {
        return "";
    }
}

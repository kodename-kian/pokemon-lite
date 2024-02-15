package model;

public class CapturedPokemon extends Pokemon {

    private String nickname;

    // EFFECTS: creates a captured Pokemon with specified species and type
    public CapturedPokemon(String species, String type) {
        super(species, type);
        this.nickname = "";
    }

    // EFFECTS: returns nickname of captured pokemon
    public String getNickname() {
        return this.nickname; //stub
    }

    // MODIFIES: this
    // EFFECTS: sets a nickname for Pokemon
    public void setNickname(String s) {
        this.nickname = s;
    }

    // EFFECTS: returns combined String of nickname and species
    @Override
    public String getDisplayName() {
        if (this.nickname.equals("")) {
            return super.getDisplayName();
        } else {
            return this.nickname + " (" + super.getDisplayName() + ")";
        }
    }
}

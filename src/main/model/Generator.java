package model;

// a helper class to generate new, random Pokemon and moves
public class Generator {

    public Generator() {

    }

    // EFFECTS: returns a new Pokemon object
    public Pokemon generatePokemon() {
        return new Pokemon("", "");
    }

    // EFFECTS: returns a new Move object
    public Move generateMove() {
        return new Move("", "");
    }
}

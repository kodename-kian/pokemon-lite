package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

// a helper class to generate new, random Pokemon and moves
public class Generator {
    private static final int MAX_POKEMON = 151;
    private static final int MAX_TYPES = 18;
    private static final int MAX_MOVES = 8;

    private Random random = new Random();

    List<String> allPokemon;
    List<String> allTypes;
    List<String> allMoves;

    // REQUIRES: file paths lead to valid files
    // EFFECTS: instantiates lists read from given file paths
    public Generator() throws IOException {
        allPokemon = Files.readAllLines(Path.of("data/pokemon"));
        allTypes = Files.readAllLines(Path.of("data/types"));
        allMoves = Files.readAllLines(Path.of("data/moves"));
    }

    // EFFECTS: returns a new Pokemon object with two moves
    public Pokemon generatePokemon() {
        int pokemonIndex = random.nextInt(MAX_POKEMON);
        int typeIndex = random.nextInt(MAX_TYPES);

        Pokemon p = new Pokemon(allPokemon.get(pokemonIndex), allTypes.get(typeIndex));

        p.learnMove(this.generateMove());
        p.learnMove(this.generateMove());

        return p;
    }

    // EFFECTS: returns a new Move object
    public Move generateMove() {
        int typeIndex = random.nextInt(MAX_TYPES);
        int moveIndex = random.nextInt(MAX_MOVES);
        return new Move(allTypes.get(typeIndex), allMoves.get(moveIndex));
    }
}

package persistence;

import model.CapturedPokemon;
import model.Move;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonTest {
    protected CapturedPokemon testPokemon1;
    protected CapturedPokemon testPokemon2;
    protected CapturedPokemon testPokemon3;

    protected void initTestPokemon() {
        testPokemon1 = new CapturedPokemon("Charmander", "Fire");
        testPokemon1.setNickname("Bob");
        testPokemon1.learnMove(new Move("Water", "Slash"));
        testPokemon1.learnMove(new Move("Dark", "Blast"));

        testPokemon2 = new CapturedPokemon("Mewtwo", "Fairy");
        testPokemon2.learnMove(new Move("Fairy", "Beam"));
        testPokemon2.learnMove(new Move("Fire", "Rush"));
        testPokemon2.learnMove(new Move("Bug", "Kick"));

        testPokemon3 = new CapturedPokemon("Voltorb", "Ice");
        testPokemon3.setNickname("Voltorb");
        testPokemon3.learnMove(new Move("Electric", "Slash"));
        testPokemon3.learnMove(new Move("Fire", "Beam"));
        testPokemon3.learnMove(new Move("Ice", "Rush"));
        testPokemon3.learnMove(new Move("Fighting", "Kick"));
    }

    protected void compareCapturedPokemon(CapturedPokemon ref, CapturedPokemon test) {
        assertEquals(ref.getDisplayName(), test.getDisplayName());
        assertEquals(ref.getNickname(), test.getNickname());
        assertEquals(ref.getType(), test.getType());
        assertEquals(ref.getNumMoves(), test.getNumMoves());

        for (int index = 0; index < ref.getNumMoves(); index++) {
            assertTrue(ref.getMove(index).isEqual(test.getMove(index)));
        }
    }
}

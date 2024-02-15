package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonTest {

    Pokemon p1;
    Pokemon p2;
    Move m1;
    Move m2;

    @BeforeEach
    public void setup() {
        p1 = new Pokemon("Pikachu", "Bug"); //haha

        p2 = new Pokemon("Gengar", "Dark");
        p2.learnMove(new Move("Dark", "Beam"));
        p2.learnMove(new Move("Normal", "Punch"));

        m1 = new Move("Water", "Kick");
        m2 = new Move("Fire", "Slash");
    }

    @Test
    public void constructorTest() {
        assertEquals("Bug", p1.getType());
        assertEquals("Pikachu", p1.getDisplayName());
    }

    @Test
    public void learnMoveTestSingle() {
        assertEquals(0, p1.getNumMoves());

        p1.learnMove(m1);
        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Water Kick");

        assertEquals(1, p1.getNumMoves());
        assertEquals(expectedOutput, p1.getMoveNames());
        assertEquals(m1, p1.getMove(0));
    }

    @Test
    public void learnMoveTestMultiple() {
        assertEquals(2, p2.getNumMoves());

        p2.learnMove(m2);
        assertEquals(3, p2.getNumMoves());

        p2.learnMove(m1);
        assertEquals(4, p2.getNumMoves());

        List<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Dark Beam");
        expectedOutput.add("Normal Punch");
        expectedOutput.add("Fire Slash");
        expectedOutput.add("Water Kick");

        assertEquals(expectedOutput, p2.getMoveNames());
        assertEquals(m2, p2.getMove(2));
        assertEquals(m1, p2.getMove(3));
    }

    @Test
    public void captureTest() {
        CapturedPokemon cp1 = p1.capture();
        CapturedPokemon cp2 = p2.capture();

        assertEquals(p1.getMoveNames(), cp1.getMoveNames());
        assertTrue(p1.getNumMoves() == cp1.getNumMoves());
        assertTrue(p1.getType() == cp1.getType());
        assertTrue(p1.getDisplayName() == cp1.getDisplayName());

        assertEquals(p2.getMoveNames(), cp2.getMoveNames());
        assertTrue(p2.getNumMoves() == cp2.getNumMoves());
        assertTrue(p2.getType() == cp2.getType());
        assertTrue(p2.getDisplayName() == cp2.getDisplayName());
        assertTrue(p2.getMove(0).isEqual(cp2.getMove(0)));
        assertTrue(p2.getMove(1).isEqual(cp2.getMove(1)));
    }
}

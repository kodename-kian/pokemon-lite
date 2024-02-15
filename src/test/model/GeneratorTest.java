package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {
    Generator g1;
    Generator g2;

    @Test
    public void generatorTestException(){
        try {
            g1 = new Generator("generation7");
            fail("An exception should be returned!");
        } catch (IOException e) {
            // do nothing-- this is the intended behavior
        }
    }

    @Test
    public void generatePokemonTest() {
        try {
            g2 = new Generator("generation1");
        } catch (IOException e) {
            fail("This code should not throw an exception!");
        }
        Pokemon p = g2.generatePokemon();
        assertEquals("model.Pokemon", p.getClass().getName());
        assertEquals(2, p.getNumMoves());
    }

    @Test
    public void generateMoveTest() {
        try {
            g2 = new Generator("generation1");
        } catch (IOException e) {
            fail("This code should not throw an exception!");
        }
        Move m = g2.generateMove();
        assertEquals("model.Move", m.getClass().getName());
        assertEquals("java.lang.String", m.getDisplayName().getClass().getName());
    }

}

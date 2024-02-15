package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {
    Generator g1;

    @BeforeEach
    public void setup() {
        try {
            g1 = new Generator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void generatePokemonTest() {
        Pokemon p = g1.generatePokemon();
        assertEquals("model.Pokemon", p.getClass().getName());
        assertEquals(2, p.getNumMoves());
    }

    @Test
    public void generateMoveTest() {
        Move m = g1.generateMove();
        assertEquals("model.Move", m.getClass().getName());
        assertEquals("java.lang.String", m.getDisplayName().getClass().getName());
    }

}

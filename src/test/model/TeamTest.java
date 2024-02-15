package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {

    CapturedPokemon cp1;
    CapturedPokemon cp2;
    CapturedPokemon cp3;
    CapturedPokemon cp4;

    Team t;

    List<String> expectedOutput;

    @BeforeEach
    public void setup() {
        cp1 = new CapturedPokemon("Pikachu", "Electric");
        cp2 = new CapturedPokemon("Mew", "Psychic");
        cp3 = new CapturedPokemon("Gyarados", "Water");
        cp4 = new CapturedPokemon("Caterpie", "Bug");

        cp3.setNickname("Gary");

        t = new Team();
        t.addPokemon(cp1);
        t.addPokemon(cp2);
        t.addPokemon(cp3);
        t.addPokemon(cp4);

        expectedOutput = new ArrayList<String>();
        expectedOutput.add("Pikachu");
        expectedOutput.add("Mew");
        expectedOutput.add("Gary (Gyarados)");
        expectedOutput.add("Caterpie");

    }

    @Test
    // all other methods in Team can be tested naturally
    // as a part of testing removePokemon
    public void removePokemonTest() {
        assertEquals(4, t.getTeamSize());
        assertEquals(expectedOutput, t.getDisplayNames());
        assertEquals(cp2, t.getPokemon(1));

        t.removePokemon(1);
        expectedOutput.remove(1);

        assertEquals(3, t.getTeamSize());
        assertEquals(expectedOutput, t.getDisplayNames());
        assertEquals(cp3, t.getPokemon(1));

        t.removePokemon(0);
        expectedOutput.remove(0);

        assertEquals(2, t.getTeamSize());
        assertEquals(expectedOutput, t.getDisplayNames());
        assertEquals(cp3, t.getPokemon(0));

        t.removePokemon(1);
        expectedOutput.remove(1);

        assertEquals(1, t.getTeamSize());
        assertEquals(expectedOutput, t.getDisplayNames());
        assertEquals(cp3, t.getPokemon(0));

        t.removePokemon(0);
        expectedOutput.remove(0);

        assertEquals(0, t.getTeamSize());
        assertEquals(expectedOutput, t.getDisplayNames());
    }
}

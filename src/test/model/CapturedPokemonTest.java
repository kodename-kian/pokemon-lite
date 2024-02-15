package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CapturedPokemonTest {

    CapturedPokemon cp1;
    CapturedPokemon cp2;

    @BeforeEach
    public void setup() {
        cp1 = new CapturedPokemon("Charmander", "Grass");
        cp2 = new CapturedPokemon("Squirtle", "Fire");

        cp2.setNickname("Bobby Chobby");
    }

    @Test
    public void setNicknameTestNew() {
        assertEquals("Charmander", cp1.getDisplayName());
        assertEquals("", cp1.getNickname());

        cp1.setNickname("Jerry");

        assertEquals("Jerry (Charmander)", cp1.getDisplayName());
        assertEquals("Jerry", cp1.getNickname());
    }

    @Test
    public void setNicknameTestExisting() {
        assertEquals("Bobby Chobby (Squirtle)", cp2.getDisplayName());
        assertEquals("Bobby Chobby", cp2.getNickname());

        cp2.setNickname("Bobby");

        assertEquals("Bobby (Squritle)", cp1.getDisplayName());
        assertEquals("Bobby", cp1.getNickname());
    }

    @Test
    public void setNicknameTestClear() {
        cp2.setNickname("");

        assertEquals("Squirtle", cp1.getDisplayName());
        assertEquals("", cp1.getNickname());
    }
}

package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    Move m1;
    Move m2;
    Move m3;

    @BeforeEach
    public void setup() {
        m1 = new Move("Poison", "Slash");
        m2 = new Move("Dark", "Beam");
        m3 = new Move("Poison", "Slash");
    }

    @Test
    public void getDisplayNameTest() {
        assertEquals("Poison Slash", m1.getDisplayName());
        assertEquals("Dark Beam", m2.getDisplayName());
    }

    @Test
    public void equalsTest() {
        assertTrue(m1.isEqual(m3));
        assertTrue(m3.isEqual(m1));
        assertFalse(m2.isEqual(m1));
        assertFalse(m3.isEqual(m2));
    }
}

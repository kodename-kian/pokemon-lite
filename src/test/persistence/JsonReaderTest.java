package persistence;

import model.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReaderTest extends JsonTest {
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/wrongFile.json");
        try {
            Team team = reader.read();
            fail("An exception should have been thrown!");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyTeam() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTeam.json");
        try {
            Team team = reader.read();
            assertEquals(0, team.getTeamSize());
        } catch (IOException e) {
            fail("File should have been read!");
        }
    }

    @Test
    void testReaderGenericTeam() {
        JsonReader reader = new JsonReader("./data/testReaderGenericTeam.json");
        try {
            Team team = reader.read();
            assertEquals(2, team.getTeamSize());

            initTestPokemon();
            compareCapturedPokemon(testPokemon1, team.getPokemon(0));
            compareCapturedPokemon(testPokemon2, team.getPokemon(1));
        } catch (IOException e) {
            fail("File should have been read!");
        }
    }
}

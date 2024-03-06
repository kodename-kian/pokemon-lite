package persistence;

import model.Team;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            Team team = new Team();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("An exception should have been thrown!");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Team team = new Team();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTeam.json");
            writer.open();
            writer.write(team);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTeam.json");
            team = reader.read();
            assertEquals(0, team.getTeamSize());
        } catch (IOException e) {
            fail("An exception should not have been thrown!");
        }
    }

    @Test
    void testWriterGenericTeam() {
        try {
            initTestPokemon();
            Team team = new Team();
            team.addPokemon(testPokemon3);
            team.addPokemon(testPokemon2);
            JsonWriter writer = new JsonWriter("./data/testWriterGenericTeam.json");
            writer.open();
            writer.write(team);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGenericTeam.json");
            team = reader.read();

            assertEquals(2, team.getTeamSize());
            compareCapturedPokemon(testPokemon3, team.getPokemon(0));
            compareCapturedPokemon(testPokemon2, team.getPokemon(1));

        } catch (IOException e) {
            fail("An exception should not have been thrown!");
        }
    }
}

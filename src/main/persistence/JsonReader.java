package persistence;

import model.Team;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a reader that reads a Team from JSON data stored in a file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        // stub;
    }

    // EFFECTS: reads Team from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Team read() throws IOException {
        return new Team(); // stub;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return ""; // stub;
    }

    // EFFECTS: parses Team from JSON object and returns it
    private Team parseTeam(JSONObject jsonObject) {
        return new Team(); // stub;
    }

    // MODIFIES: team
    // EFFECTS: parses array of CapturedPokemon from JSON object and adds them to Team
    private void addAllPokemon(Team team, JSONObject jsonObject) {
        // stub;
    }

    // MODIFIES: team
    // EFFECTS: parses individual CapturedPokemon from JSON object and adds it to Team
    private void addPokemon(Team team, JSONObject jsonObject) {
        // stub;
    }
}

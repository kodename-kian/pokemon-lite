package persistence;

import model.CapturedPokemon;
import model.Move;
import model.Team;
import model.phase4.Event;
import model.phase4.EventLog;
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
        this.source = source;
    }

    // EFFECTS: reads Team from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Team read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);

        EventLog.getInstance().logEvent(new Event("Player loaded game from memory."));

        return parseTeam(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Team from JSON object and returns it
    private Team parseTeam(JSONObject jsonObject) {
        Team team = new Team();
        addAllPokemon(team, jsonObject);
        return team;
    }

    // MODIFIES: team
    // EFFECTS: parses array of CapturedPokemon from JSON object and adds them to Team
    private void addAllPokemon(Team team, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("team");
        for (Object json : jsonArray) {
            JSONObject nextPokemon = (JSONObject) json;
            addPokemon(team, nextPokemon);
        }
    }

    // MODIFIES: team
    // EFFECTS: parses individual CapturedPokemon from JSON object and adds it to Team
    private void addPokemon(Team team, JSONObject jsonObject) {
        String species = jsonObject.getString("species");
        String type = jsonObject.getString("type");

        CapturedPokemon pokemon = new CapturedPokemon(species, type);

        String nickname = jsonObject.getString("nickname");
        pokemon.setNickname(nickname);

        JSONArray jsonArray = jsonObject.getJSONArray("moves");
        for (Object json : jsonArray) {
            JSONObject nextMove = (JSONObject) json;
            addMove(pokemon, nextMove);
        }

        team.addPokemon(pokemon);
    }

    // MODIFIES: pokemon
    // EFFECTS: parses individual Move from JSON object and adds it to CapturedPokemon
    private void addMove(CapturedPokemon pokemon, JSONObject jsonObject) {
        String type = jsonObject.getString("type");
        String attack = jsonObject.getString("attack");
        pokemon.learnMove(new Move(type, attack));
    }
}

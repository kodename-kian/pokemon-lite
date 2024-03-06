package persistence;

import model.Team;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Referenced from the JsonSerialization Demo
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a writer that writes a Team into JSON data stored in a file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        // stub;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        // stub;
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of Team to file
    public void write(Team team) {
        // stub;
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        // stub;
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        // stub;
    }
}

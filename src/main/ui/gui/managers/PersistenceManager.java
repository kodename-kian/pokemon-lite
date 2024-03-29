package ui.gui.managers;

import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// A class to handle persistence for the MainWindow
public class PersistenceManager {

    private static final String SAVE_ADDRESS = "./data/myTeam.json";

    private final JsonWriter writer;
    private final JsonReader reader;

    private Team team;

    // EFFECTS: initializes PersistenceManager
    public PersistenceManager(Team team) {
        this.writer = new JsonWriter(SAVE_ADDRESS);
        this.reader = new JsonReader(SAVE_ADDRESS);
        this.team = team;
    }

    // EFFECTS: saves Team to memory
    public void saveTeam() {
        try {
            writer.open();
            writer.write(this.team);
            writer.close();
            JOptionPane.showMessageDialog(null,
                    "Game successfully saved to " + SAVE_ADDRESS);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Something went wrong! Unable to save game at " + SAVE_ADDRESS,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this.team
    // EFFECTS: loads Team data in from memory
    public Team loadTeam() {
        try {
            this.team = reader.read();
            JOptionPane.showMessageDialog(null,
                    "Save successfully loaded from " + SAVE_ADDRESS);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Something went wrong! Unable to load game from " + SAVE_ADDRESS,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return this.team;
    }
}

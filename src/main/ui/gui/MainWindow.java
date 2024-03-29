package ui.gui;

import model.Generator;
import model.Team;
import ui.gui.managers.PersistenceManager;
import ui.gui.panels.EncounterPanel;
import ui.gui.panels.GamePanel;
import ui.gui.panels.TeamPanel;

import javax.swing.*;
import java.io.IOException;

// Main window for the GUI
public class MainWindow extends JFrame {

    private Team team;

    private final JPanel gamePanel;

    private final PersistenceManager persistenceManager;

    private final Generator generator;

    // MODIFIES: this
    // EFFECTS: constructs the GUI and starts the game
    public MainWindow() {

        super("Pokemon Lite");

        this.team = new Team();

        persistenceManager = new PersistenceManager(this.team);

        try {
            generator = new Generator("generation1");
        } catch (IOException e) {
            throw new RuntimeException(e); //should never happen!
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gamePanel = new GamePanel();

        equip(gamePanel);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: clears this panel to equip a new panel
    private void equip(JPanel panel) {
        this.getContentPane().removeAll();
        this.repaint();
        this.add(panel);
        this.pack();
    }

    // EFFECTS: returns this.team
    public Team getTeam() {
        return this.team;
    }

    // EFFECTS: returns this.generator
    public Generator getGenerator() {
        return this.generator;
    }

    // MODIFIES: this
    // EFFECTS: switches panel based on specified select
    public void switchPanel(String select) {
        switch (select) {
            case "GAME":
                equip(gamePanel);
                break;
            case "TEAM":
                equip(new TeamPanel(this.team));
                break;
            case "ENCOUNTER":
                equip(new EncounterPanel(this.generator.generatePokemon()));
                break;
        }
    }

    // EFFECTS: saves game to memory
    public void saveGame() {
        persistenceManager.saveTeam();
    }

    // MODIFIES: this.team
    // EFFECTS: loads Team from memory
    public void loadGame() {
        this.team = persistenceManager.loadTeam();
    }
}

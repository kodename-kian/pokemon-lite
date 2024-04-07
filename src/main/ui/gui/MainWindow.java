package ui.gui;

import model.Generator;
import model.Team;
import model.phase4.Event;
import model.phase4.EventLog;
import ui.gui.managers.PersistenceManager;
import ui.gui.panels.EncounterPanel;
import ui.gui.panels.GamePanel;
import ui.gui.panels.TeamPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dumpLog();
                System.exit(0);
            }
        });

        gamePanel = new GamePanel();

        equip(gamePanel);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    // EFFECTS: prints all the contents of log
    private void dumpLog() {
        System.out.println("APP CLOSING... PRINTING SESSION LOG:");
        for (Event event : EventLog.getInstance()) {
            System.out.println();
            System.out.println(event.toString());
        }
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

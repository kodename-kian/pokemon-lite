package ui.gui;

import model.Team;
import ui.gui.managers.PersistenceManager;
import ui.gui.panels.GamePanel;
import ui.gui.panels.TeamPanel;

import javax.swing.*;

public class MainWindow extends JFrame {

    Team team;

    JPanel gamePanel;
    JPanel teamPanel;

    PersistenceManager persistenceManager;

    public MainWindow() {

        super("Pokemon Lite");

        this.team = new Team();

        persistenceManager = new PersistenceManager(this.team);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gamePanel = new GamePanel();
        teamPanel = new TeamPanel();

        equip(gamePanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void equip(JPanel panel) {
        this.getContentPane().removeAll();
        this.repaint();
        this.add(panel);
        this.pack();
        System.out.println("ok");
    }




    public void saveGame() {
        persistenceManager.saveTeam();
    }

    public void loadGame() {
        persistenceManager.loadTeam();
    }
}

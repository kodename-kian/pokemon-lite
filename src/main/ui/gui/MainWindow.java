package ui.gui;

import ui.gui.panels.GamePanel;
import ui.gui.panels.TeamPanel;

import javax.swing.*;

public class MainWindow extends JFrame {

    JPanel gamePanel;
    JPanel teamPanel;

    public MainWindow() {

        super("Pokemon Lite");

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
}

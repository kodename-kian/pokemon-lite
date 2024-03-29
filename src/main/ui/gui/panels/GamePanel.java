package ui.gui.panels;

import ui.gui.listeners.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// JPanel Class for the main game window
public class GamePanel extends JPanel {

    // MODIFIES: this
    // EFFECTS: creates the GamePanel
    public GamePanel() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(625, 450));

        initGraphicsPanel();
        initControlPanel();
    }

    // MODIFIES: this
    // EFFECTS: creates and adds the graphics portion of this panel
    private void initGraphicsPanel() {
        JPanel graphicsPanel = new JPanel();

        JButton encounterButton = new JButton("Encounter Pokemon");
        encounterButton.addActionListener(new EncounterListener());

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File("./data/images/game.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image image = bufferedImage.getScaledInstance(600, 400, Image.SCALE_DEFAULT);

        JLabel graphicsLabel = new JLabel(new ImageIcon(image));
        graphicsLabel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        graphicsLabel.add(encounterButton);
        graphicsPanel.add(graphicsLabel);
        this.add(graphicsPanel);
    }

    // MODIFIES: this
    // EFFECTS: creates and adds the control portion of this panel
    private void initControlPanel() {
        JPanel controlPanel = new JPanel();
        JButton saveButton = new JButton("Save Game");
        JButton loadButton = new JButton("Load Game");
        JButton teamButton = new JButton("View Team");

        saveButton.addActionListener(new SaveListener());
        loadButton.addActionListener(new LoadListener());
        teamButton.addActionListener(new PanelSwapListener("TEAM"));

        controlPanel.add(saveButton);
        controlPanel.add(loadButton);
        controlPanel.add(teamButton);

        this.add(controlPanel);
    }

}

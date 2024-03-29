package ui.gui.panels;

import ui.gui.listeners.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {

    public GamePanel() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(625, 450));

        initGraphicsPanel();
        initControlPanel();
    }

    private void initGraphicsPanel() {
        JPanel graphicsPanel = new JPanel();

        JButton encounterButton = new JButton("Encounter Pokemon");
        encounterButton.addActionListener(new EncounterListener());

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File("./data/images/test2.jpg")); // TODO: replace with artwork
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

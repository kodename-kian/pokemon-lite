package ui.gui.panels;

import model.Pokemon;
import ui.gui.listeners.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EncounterPanel extends JPanel {

    Pokemon pokemon;

    public EncounterPanel(Pokemon pokemon) {
        super();

        this.pokemon = pokemon;
        JOptionPane.showMessageDialog(null,
                "You've encountered a wild " + this.pokemon.getDisplayName() + "!");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(625, 450));

        initGraphicsPanel();
        initControlPanel();

    }

    private void initGraphicsPanel() {
        JPanel graphicsPanel = new JPanel();

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File("./data/images/test3.jpg")); // TODO: replace with artwork
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image image = bufferedImage.getScaledInstance(600, 400, Image.SCALE_DEFAULT);

        graphicsPanel.add(new JLabel(new ImageIcon(image)));

        this.add(graphicsPanel);
    }

    private void initControlPanel() {
        JPanel controlPanel = new JPanel();
        JButton catchButton = new JButton("Catch Pokemon");
        JButton fleeButton = new JButton("Flee Encounter");

        catchButton.addActionListener(new CatchListener(this.pokemon));
        fleeButton.addActionListener(new PanelSwapListener("GAME"));

        controlPanel.add(catchButton);
        controlPanel.add(fleeButton);

        this.add(controlPanel);
    }
}

package ui.gui.panels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TeamPanel extends JPanel {

    public TeamPanel() {
        super();

        JPanel graphicsPanel = new JPanel();

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File("./data/images/test.JPG"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image image = bufferedImage.getScaledInstance(600, 400, Image.SCALE_DEFAULT);

        graphicsPanel.add(new JLabel(new ImageIcon(image)));

        this.add(graphicsPanel);
    }
}

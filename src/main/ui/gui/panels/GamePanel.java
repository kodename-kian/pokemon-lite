package ui.gui.panels;

import ui.gui.listeners.LoadListener;
import ui.gui.listeners.SaveListener;

import javax.swing.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        super();

        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);

        JPanel controlPanel = new JPanel();
        JButton saveButton = new JButton("Save Game");
        JButton loadButton = new JButton("Load Game");
        JButton teamButton = new JButton("View Team");

        saveButton.addActionListener(new SaveListener());
        loadButton.addActionListener(new LoadListener());

        controlPanel.add(saveButton);
        controlPanel.add(loadButton);
        controlPanel.add(teamButton);

        this.add(controlPanel);
    }

}

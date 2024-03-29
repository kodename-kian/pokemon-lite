package ui.gui.panels;

import model.Team;
import ui.gui.listeners.PanelSwapListener;

import javax.swing.*;
import java.awt.*;

public class TeamPanel extends JPanel {

    JPanel detailPanel;

    public TeamPanel(Team team) {
        super();

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(625, 450));

        constructLeftPanel(team);
    }

    public void placeDetailPanel(PokemonPanel panel) {
        if (this.detailPanel != null) {
            this.remove(detailPanel);
        }
        this.add(panel);
        this.detailPanel = panel;
        this.repaint();
        this.revalidate();
    }

    private void constructLeftPanel(Team team) {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(175, 425));

        if (team.getTeamSize() == 0) {
            leftPanel.add(new JLabel("Team is currently empty!"));
        } else {
            leftPanel.add(constructTeamPanel(team));
        }

        leftPanel.add(Box.createVerticalGlue());

        JButton gameButton = new JButton("Back");
        gameButton.addActionListener(new PanelSwapListener("GAME"));

        leftPanel.add(gameButton);

        this.add(leftPanel);
    }

    private JScrollPane constructTeamPanel(Team team) {
        JPanel panel = new JPanel();

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        for (int index = 0; index < team.getTeamSize(); index++) {
            PokemonListPanel panel2 = new PokemonListPanel(team.getPokemon(index), index);
            panel.add(panel2);
        }

        return new JScrollPane(panel);
    }
}

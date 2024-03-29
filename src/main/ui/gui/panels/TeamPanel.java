package ui.gui.panels;

import model.Team;
import ui.gui.listeners.PanelSwapListener;

import javax.swing.*;

public class TeamPanel extends JPanel {

    public TeamPanel(Team team) {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if (team.getTeamSize() == 0) {
            this.add(new JLabel("Team is currently empty!"));
        } else {
            constructTeamPanel(team);
        }

        JButton gameButton = new JButton("Back");
        gameButton.addActionListener(new PanelSwapListener("GAME"));

        this.add(gameButton);
    }

    private void constructTeamPanel(Team team) {
        JPanel panel = new JPanel();

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        for (int index = 0; index < team.getTeamSize(); index++) {
            PokemonListPanel panel2 = new PokemonListPanel(team.getPokemon(index));
            panel.add(panel2);
        }

        JScrollPane scrollPane = new JScrollPane(panel);

        this.add(scrollPane);
    }
}

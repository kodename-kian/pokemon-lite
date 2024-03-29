package ui.gui.panels;

import model.CapturedPokemon;
import ui.gui.listeners.*;

import javax.swing.*;
import java.awt.*;

public class PokemonPanel extends JPanel {
    public PokemonPanel(CapturedPokemon pokemon, int index) {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(400, 425));

        this.add(Box.createVerticalGlue());

        this.add(constructMainInfoBar(pokemon, index));
        this.add(constructMovesList(pokemon));

        this.add(Box.createVerticalGlue());

        this.add(constructButtonBar(index));
    }

    private JScrollPane constructMainInfoBar(CapturedPokemon pokemon, int index) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("POKEMON " + (index + 1) + ": " + pokemon.getDisplayName()));
        panel.add(new JLabel("TYPE: " + pokemon.getType()));

        return new JScrollPane(panel);
    }

    private JScrollPane constructMovesList(CapturedPokemon pokemon) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("MOVES:"));

        for (int index = 0; index < pokemon.getNumMoves(); index++) {
            panel.add(new JLabel((index +  1) + ". " + pokemon.getMove(index).getDisplayName()));
        }

        return new JScrollPane(panel);
    }

    private JPanel constructButtonBar(int index) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton newMoveButton = new JButton("Learn New Move");
        newMoveButton.addActionListener(new MoveListener(index));
        panel.add(newMoveButton);

        JButton removeButton = new JButton("Release Pokemon");
        removeButton.addActionListener(new ReleaseListener(index));
        panel.add(removeButton);

        return panel;
    }

}

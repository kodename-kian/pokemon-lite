package ui.gui.panels;

import model.CapturedPokemon;
import ui.gui.listeners.ReleaseListener;

import javax.swing.*;
import java.awt.*;

public class PokemonPanel extends JPanel {
    public PokemonPanel(CapturedPokemon pokemon, int index) {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(400, 425));

        this.add(Box.createVerticalGlue());

        JPanel ayoh = new JPanel();
        ayoh.setLayout(new BoxLayout(ayoh, BoxLayout.Y_AXIS));

        ayoh.add(new JLabel("POKEMON " + (index + 1) + ": " + pokemon.getDisplayName()));
        ayoh.add(new JLabel("TYPE: " + pokemon.getType()));

        this.add(new JScrollPane(ayoh));
        this.add(constructMovesList(pokemon));

        this.add(Box.createVerticalGlue());

        JButton removeButton = new JButton("Release Pokemon");
        removeButton.addActionListener(new ReleaseListener(index));
        this.add(removeButton);
    }


    private JScrollPane constructMovesList(CapturedPokemon pokemon) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        panel.add(new JLabel("MOVES:"));

        for (int index = 0; index < pokemon.getNumMoves(); index++) {
            panel.add(new JLabel((index +  1) + ". " + pokemon.getMove(index).getDisplayName()));
        }

        return new JScrollPane(panel);
    }

}

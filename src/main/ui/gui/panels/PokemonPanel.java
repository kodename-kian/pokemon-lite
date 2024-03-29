package ui.gui.panels;

import model.CapturedPokemon;
import ui.gui.listeners.*;

import javax.swing.*;
import java.awt.*;

// JPanel Class for the in-detail view of a Pokemon
public class PokemonPanel extends JPanel {

    // MODIFIES: this
    // EFFECTS: creates the PokemonPanel
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

    // MODIFIES: this
    // EFFECTS: creates and returns a panel for the main information about the Pokemon
    private JScrollPane constructMainInfoBar(CapturedPokemon pokemon, int index) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("POKEMON " + (index + 1) + ": " + pokemon.getDisplayName()));
        panel.add(new JLabel("TYPE: " + pokemon.getType()));

        return new JScrollPane(panel);
    }

    // MODIFIES: this
    // EFFECTS: creates and returns a panel for the list of Moves of the Pokemon
    private JScrollPane constructMovesList(CapturedPokemon pokemon) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("MOVES:"));

        for (int index = 0; index < pokemon.getNumMoves(); index++) {
            panel.add(new JLabel((index +  1) + ". " + pokemon.getMove(index).getDisplayName()));
        }

        return new JScrollPane(panel);
    }

    // MODIFIES: this
    // EFFECTS: creates and returns the control portion of this panel
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

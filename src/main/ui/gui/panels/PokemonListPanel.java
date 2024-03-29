package ui.gui.panels;

import model.CapturedPokemon;
import ui.gui.listeners.ViewListener;

import javax.swing.*;
import java.awt.*;

// JPanel Class for a single item in the PokemonPanel
public class PokemonListPanel extends JPanel {

    // MODIFIES: this
    // EFFECTS: creates the PokemonListPanel
    public PokemonListPanel(CapturedPokemon pokemon, int index) {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(200, 50));

        JLabel display = new JLabel(pokemon.getDisplayName());
        JButton viewButton = new JButton("Details");
        viewButton.addActionListener(new ViewListener(pokemon, index));

        this.add(display);
        this.add(viewButton);
    }
}

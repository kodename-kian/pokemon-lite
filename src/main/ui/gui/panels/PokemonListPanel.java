package ui.gui.panels;

import model.CapturedPokemon;
import ui.gui.listeners.ViewListener;

import javax.swing.*;
import java.awt.*;

public class PokemonListPanel extends JPanel {

    public PokemonListPanel(CapturedPokemon pokemon) {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setPreferredSize(new Dimension(200, 50));

        JLabel display = new JLabel(pokemon.getDisplayName());
        JButton viewButton = new JButton("Details");
        viewButton.addActionListener(new ViewListener(pokemon));

        this.add(display);
        this.add(viewButton);
    }
}

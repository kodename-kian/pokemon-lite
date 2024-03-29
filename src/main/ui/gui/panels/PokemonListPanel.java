package ui.gui.panels;

import model.CapturedPokemon;

import javax.swing.*;

public class PokemonListPanel extends JPanel {

    public PokemonListPanel(CapturedPokemon pokemon) {
        super();
        JLabel display = new JLabel(pokemon.getDisplayName());
        this.add(display);
    }
}

package ui.gui.panels;

import model.CapturedPokemon;

import javax.swing.*;

public class PokemonPanel extends JPanel {
    public PokemonPanel(CapturedPokemon pokemon) {
        super();
        this.add(new JLabel(pokemon.getDisplayName()));
    }
}

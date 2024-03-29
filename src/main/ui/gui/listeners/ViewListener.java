package ui.gui.listeners;

import model.CapturedPokemon;
import ui.gui.panels.PokemonPanel;

import java.awt.*;
import java.awt.event.ActionEvent;

// ActionListener that handles viewing details of specific Pokemon
public class ViewListener extends AbstractListener {

    private final CapturedPokemon pokemon;
    private final int index;

    // EFFECTS: constructor with a Pokemon and integer field
    public ViewListener(CapturedPokemon pokemon, int index) {
        super();
        this.pokemon = pokemon;
        this.index = index;
    }

    // MODIFIES: TeamPanel getTeamPanel((Component)obj)
    // EFFECTS: adds the detail-view of a Pokemon to TeamPanel
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getTeamPanel((Component)obj).placeDetailPanel(new PokemonPanel(this.pokemon, this.index));
    }
}

package ui.gui.listeners;

import model.CapturedPokemon;
import ui.gui.panels.PokemonPanel;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ViewListener extends AbstractListener {

    private final CapturedPokemon pokemon;

    public ViewListener(CapturedPokemon pokemon) {
        super();
        this.pokemon = pokemon;
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getTeamPanel((Component)obj).placeDetailPanel(new PokemonPanel(this.pokemon));
    }
}

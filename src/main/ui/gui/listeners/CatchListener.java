package ui.gui.listeners;

import model.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CatchListener extends AbstractListener {
    private final Pokemon pokemon;

    public CatchListener(Pokemon pokemon) {
        super();
        this.pokemon = pokemon;
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getMainWindow((Component)obj).getTeam().addPokemon(this.pokemon.capture());
        JOptionPane.showMessageDialog(null,
                this.pokemon.getDisplayName() + " has been successfully captured!");
        getMainWindow((Component)obj).switchPanel("GAME");
    }
}

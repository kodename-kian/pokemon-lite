package ui.gui.listeners;

import model.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// ActionListener that handles catching a new Pokemon
public class CatchListener extends AbstractListener {
    private final Pokemon pokemon;

    // EFFECTS: constructor with a Pokemon field
    public CatchListener(Pokemon pokemon) {
        super();
        this.pokemon = pokemon;
    }

    // MODIFIES: Team getMainWindow((Component)obj).getTeam(), MainWindow getMainWindow((Component)obj)
    // EFFECTS: adds given Pokemon to Team; refreshes Team panel
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getMainWindow((Component)obj).getTeam().addPokemon(this.pokemon.capture());
        JOptionPane.showMessageDialog(null,
                this.pokemon.getDisplayName() + " has been successfully captured!");
        getMainWindow((Component)obj).switchPanel("GAME");
    }
}

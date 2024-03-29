package ui.gui.listeners;

import model.CapturedPokemon;
import model.Move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// ActionListener that handles teaching a Pokemon a new Move
public class MoveListener extends AbstractListener {
    private final int index;

    // EFFECTS: constructor with an index field
    public MoveListener(int index) {
        super();
        this.index = index;
    }

    // MODIFIES: CapturedPokemon getMainWindow((Component)obj).getTeam().getPokemon(index)
    // EFFECTS: teaches Pokemon new, randomly generated Move
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        CapturedPokemon pokemon = getMainWindow((Component)obj).getTeam().getPokemon(index);
        Move move = getMainWindow((Component)obj).getGenerator().generateMove();
        pokemon.learnMove(move);
        JOptionPane.showMessageDialog(null,
                pokemon.getDisplayName() + " has learned " + move.getDisplayName());
        getMainWindow((Component)obj).switchPanel("TEAM");
    }
}

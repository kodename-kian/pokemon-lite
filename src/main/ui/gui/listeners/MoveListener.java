package ui.gui.listeners;

import model.CapturedPokemon;
import model.Move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MoveListener extends AbstractListener {
    private final int index;

    public MoveListener(int index) {
        super();
        this.index = index;
    }

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

package ui.gui.listeners;

import model.CapturedPokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// ActionListener that handles releasing a Pokemon from the team
public class ReleaseListener extends AbstractListener {
    private final int index;

    // EFFECTS: constructor with an integer field
    public ReleaseListener(int index) {
        super();
        this.index = index;
    }

    // MODIFIES: Team getMainWindow((Component)obj).getTeam()
    // EFFECTS: removes Pokemon from Team via specified index
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        CapturedPokemon pokemon = getMainWindow((Component)obj).getTeam().getPokemon(index);
        getMainWindow((Component)obj).getTeam().removePokemon(index);
        JOptionPane.showMessageDialog(null,
                pokemon.getDisplayName() + " has been released from the team!");
        getMainWindow((Component)obj).switchPanel("TEAM");
    }
}

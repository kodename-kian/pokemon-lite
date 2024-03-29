package ui.gui.listeners;

import java.awt.*;
import java.awt.event.ActionEvent;

// ActionListener that handles loading game from save
public class LoadListener extends AbstractListener {

    // MODIFIES: Team getMainWindow((Component)obj).getTeam()
    // EFFECTS: loads game from save
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getMainWindow((Component)obj).loadGame();
    }
}

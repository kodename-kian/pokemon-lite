package ui.gui.listeners;

import java.awt.*;
import java.awt.event.ActionEvent;

// ActionListener that handles saving the game
public class SaveListener extends AbstractListener {

    // EFFECTS: saves game to memory via PersistenceManager
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getMainWindow((Component)obj).saveGame();
    }
}

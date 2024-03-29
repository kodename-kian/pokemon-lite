package ui.gui.listeners;

import java.awt.*;
import java.awt.event.ActionEvent;

// ActionListener that handles starting a new encounter
public class EncounterListener extends AbstractListener {

    // MODIFIES: MainWindow getMainWindow((Component)obj)
    // EFFECTS: switches to Encounter panel
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getMainWindow((Component)obj).switchPanel("ENCOUNTER");
    }
}

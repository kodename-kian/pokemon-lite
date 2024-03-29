package ui.gui.listeners;

import java.awt.*;
import java.awt.event.ActionEvent;

// ActionListener that handles swapping panels
public class PanelSwapListener extends AbstractListener {
    private final String select;

    // EFFECTS: constructor with a String field
    public PanelSwapListener(String select) {
        super();
        this.select = select;
    }

    // MODIFIES: MainWindow getMainWindow((Component)obj)
    // EFFECTS: switches to specified panel
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getMainWindow((Component)obj).switchPanel(this.select);
    }
}
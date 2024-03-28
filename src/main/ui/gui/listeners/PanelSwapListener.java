package ui.gui.listeners;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelSwapListener extends AbstractListener {
    private final String select;

    public PanelSwapListener(String select) {
        super();
        this.select = select;
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getMainWindow((Component)obj).switchPanel(this.select);
    }
}
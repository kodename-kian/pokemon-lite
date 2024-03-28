package ui.gui.listeners;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TeamListener extends AbstractListener {
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getMainWindow((Component)obj).switchPanel("TEAM");
    }
}
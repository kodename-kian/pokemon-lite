package ui.gui.listeners;

import java.awt.*;
import java.awt.event.ActionEvent;

public class SaveListener extends AbstractListener {
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        getMainWindow((Component)obj).saveGame();
    }
}

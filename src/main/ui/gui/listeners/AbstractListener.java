package ui.gui.listeners;

import ui.gui.MainWindow;

import java.awt.*;
import java.awt.event.ActionListener;

public abstract class AbstractListener implements ActionListener {
    protected MainWindow getMainWindow(Component component) {
        Component currParent = component;
        MainWindow frame = null;
        while (currParent != null) {
            if (currParent instanceof MainWindow) {
                frame = (MainWindow)currParent;
                break;
            }
            currParent = currParent.getParent();
        }
        return frame;
    }
}

package ui.gui.listeners;

import ui.gui.MainWindow;
import ui.gui.panels.TeamPanel;

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

    protected TeamPanel getTeamPanel(Component component) {
        Component currParent = component;
        TeamPanel panel = null;
        while (currParent != null) {
            if (currParent instanceof TeamPanel) {
                panel = (TeamPanel)currParent;
                break;
            }
            currParent = currParent.getParent();
        }
        return panel;
    }
}

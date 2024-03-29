package ui.gui.listeners;

import ui.gui.MainWindow;
import ui.gui.panels.TeamPanel;

import java.awt.*;
import java.awt.event.ActionListener;

// Abstract class to hold shared ActionListener functionality
public abstract class AbstractListener implements ActionListener {

    // EFFECTS: returns the oldest ancestor of the component tree
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

    // EFFECTS: returns the team panel component ancestor
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

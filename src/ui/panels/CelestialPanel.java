package ui.panels;

import ui.DysonGUI;

public abstract class CelestialPanel {
    protected final DysonGUI gui;

    public CelestialPanel(DysonGUI gui) {
        this.gui = gui;
    }

    public abstract void update();
}

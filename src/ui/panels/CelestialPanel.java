package ui.panels;

import ui.DysonGUI;

import javax.swing.*;
import java.awt.*;

public abstract class CelestialPanel extends JPanel {
    private final DysonGUI gui;
    private JLabel image;

    public CelestialPanel(DysonGUI gui) {
        this.setLayout(new BorderLayout());
        this.gui = gui;

    }

    public abstract void update();
}

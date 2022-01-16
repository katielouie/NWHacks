package ui.panels;

import ui.DysonGUI;

import javax.swing.*;
import java.awt.*;

public class EarthPanel extends CelestialPanel {
    private static Image IMAGE; // stub
    private OptionPanel optionPanel;
    private JLabel image;

    public EarthPanel(DysonGUI gui) {
        super(gui);
        optionPanel = new OptionPanel();
    }

    public void initOptionPanel() {
        JButton launchbutton = optionPanel.addOption("Launch Pods");
        //launchbutton.addActionListener(e -> Earth.earth.launchPod());
    }

    @Override
    public void update() {
        // stub
    }
}

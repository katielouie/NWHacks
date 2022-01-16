package ui.panels;

import ui.DysonGUI;

import javax.swing.*;
import java.awt.*;

public class EarthPanel extends CelestialPanel {
    private static Image IMAGE; // stub
    private EarthOptionPanel earthOptionPanel;
    private JLabel image;

    public EarthPanel(DysonGUI gui) {
        super(gui);
        //setBackground(Color.BLACK);
        earthOptionPanel = new EarthOptionPanel(gui);
        add(earthOptionPanel, BorderLayout.WEST);
        image = new JLabel();
        image.setBackground(Color.black);
        image.setPreferredSize(new Dimension(400,400));
        image.setIcon(new ImageIcon("./data/Earth2.png"));
        image.setBackground(Color.black);
        add(image);
    }

    @Override
    public void update() {
        // stub
    }
}

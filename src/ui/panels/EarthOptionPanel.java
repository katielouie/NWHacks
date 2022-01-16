package ui.panels;

import model.Earth;
import ui.DysonGUI;

import javax.swing.*;
import java.awt.*;

//Panel to Display Player Options
public class EarthOptionPanel extends JPanel {
    protected static final int MARGIN = 8;

    public EarthOptionPanel(DysonGUI dysonGUI) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(500, 1000));
        setBackground(Color.black);
        addOptions();
    }

    // EFFECTS: adds vertical margin to given panel
    protected void addVerticalMargin(JPanel panel) {
        JPanel margin = new JPanel();
        margin.setBackground(Color.black);
        margin.setPreferredSize(new Dimension(0, MARGIN));
        add(margin);
    }

    //EFFECTS: Adds player Options
    // TODO: Add more Call Functions
    protected void addOptions() {
        JButton podButton = addOption("Launch Pods");
        podButton.addActionListener(e -> Earth.earth.launchPod(20,20, 10));

    }

    protected JButton addOption(String text) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 200));
        panel.setLayout(new BorderLayout());
        JButton JButton = new JButton(text);
        panel.add(JButton);
        add(panel);
        addVerticalMargin(panel);
        return JButton;
    }



}

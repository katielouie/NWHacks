package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// EFFECTS: Displays player's funds, resources, equipment, etc.
public class Toolbar extends JPanel {
    private static final int SIZE = 10;
    private static final ArrayList<Image> ICONS = new ArrayList<>();
    private static final ArrayList<String> LABELS = new ArrayList<>();
    private ArrayList<Component> components;
    private DysonGUI gui;

    public Toolbar(DysonGUI gui, ArrayList<Long> values) {
        this.gui = gui;
        for (int i = 0; i < SIZE; i++) {
            Image image = ICONS.get(i);
            String label = LABELS.get(i);
            Long value = values.get(i);
            // stub
        }
    }

    private class Component extends JPanel {
        private JLabel label;
        private JLabel valueDisplay;
        private ImageIcon imageIcon;

        public Component(Long value) {
            //stub
        }

        public void update(Long value) {
            //stub
        }
    }

    public void update(ArrayList<Long> values) {
        for (int i = 0; i < SIZE; i++) {
            Component component = components.get(i);
            Long value = values.get(i);
            component.update(value);
        }
    }
}

package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

// EFFECTS: Displays player's funds, resources, equipment, etc.
public class Toolbar extends JPanel {
    private static final int SIZE = 3;
    private static final ArrayList<Image> ICONS = new ArrayList<>();
    private static final ArrayList<String> LABELS = new ArrayList<>(Arrays.asList("Funds", "Resources", "Equipment"));
    private ArrayList<Component> components;
    private DysonGUI gui;

    public Toolbar(DysonGUI gui, ArrayList<Long> values) {
        this.gui = gui;
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        components = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            String label = LABELS.get(i);
            Long value = values.get(i);
            Component component = new Component(label, value);
            components.add(component);
            this.add(component);
        }
    }

    private class Component extends JPanel {
        private final JLabel label;
        private JLabel valueDisplay;
        private ImageIcon imageIcon;

        public Component(String label, Long value) {
            this.label = new JLabel(label);
            this.valueDisplay = new JLabel(String.valueOf(value));
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
            this.add(this.label);
            this.add(valueDisplay);
        }

        public void update(Long value) {
            label.setText(String.valueOf(value));
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

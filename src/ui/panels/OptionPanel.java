package ui.panels;

import javax.swing.*;
import java.awt.*;

public class OptionPanel extends JPanel {
    protected static final int MARGIN = 8;

    public OptionPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    // EFFECTS: adds vertical margin to given panel
    protected void addVerticalMargin(JPanel panel) {
        JPanel margin = new JPanel();
        margin.setPreferredSize(new Dimension(0, MARGIN));
        panel.add(margin);
    }

    protected JButton addOption(String Option) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton button = new JButton(Option);
        panel.add(button);
        return button;
    }


}

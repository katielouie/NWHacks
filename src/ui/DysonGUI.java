package ui;

import model.Earth;
import model.Mercury;
import model.Sun;
import ui.panels.CelestialPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;

public class DysonGUI extends JFrame {
    private ArrayList<CelestialPanel> panels;
    private Toolbar toolbar;


    public DysonGUI() {
        super("Dyson Game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUIFont (new javax.swing.plaf.FontUIResource("Serif",Font.PLAIN,20));
        this.setBackground(Color.black);
        setVisible(true);
        generatePlanets();
        toolbar = new Toolbar(this, getToolbarValues());
        this.add(toolbar, BorderLayout.NORTH);
    }

    //Generates Planets
    public void generatePlanets() {
        Earth.generateEarth();
        Mercury.generateMercury();
        Sun.generateSun();
    }

    public ArrayList<Long> getToolbarValues() {
        ArrayList<Long> values = new ArrayList<>();
        values.add(Earth.earth.getFunds());
        values.add(Mercury.mercury.getResources());
        values.add(Mercury.mercury.getEquipment());
        return values;
    }
    public void update() {
        toolbar.update(getToolbarValues());
    }

    public static void setUIFont (javax.swing.plaf.FontUIResource f){
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }
}

package model;

public class Sun {
    public static Sun sun;
    private long panels;
    private long transmittersToEarth;
    private long transmittersToMercury;

    public static void generateSun() {
        sun = new Sun();
    }

    private Sun() {
        panels = 0;
        transmittersToEarth = 0;
        transmittersToMercury = 0;
    }

    public void addPanels(long panels) {
        this.panels += panels;
    }

    public long getPanels() {
        return panels;
    }

    public long getTransmittersToEarth() {
        return transmittersToEarth;
    }

    public long getTransmittersToMercury() {
        return transmittersToMercury;
    }
}

package model;

public class Sun {
    public static Sun sun;
    private long panelsToEarth;
    private long panelsToMercury;

    public static void generateSun() {
        sun = new Sun();
    }

    private Sun() {
        panelsToEarth = 0;
        panelsToMercury = 0;
    }

    public void addPanels(long panels) {
        panelsToEarth += panels;
    }

    public void switchToEarth(long panels) {
        panelsToMercury -= panels;
        panelsToEarth += panels;
    }

    public void switchToMercury(long panels) {
        panelsToMercury -= panels;
        panelsToEarth += panels;
    }

    public long getPanelsToEarth() {
        return panelsToEarth;
    }

    public long getPanelsToMercury() {
        return panelsToMercury;
    }
}

package model;

public class Earth {
    public static Earth earth;
    private long funds;
    private long rockets;
    private long receptors;

    private static int RESOURCE_COST = 1;
    private static int EQUIPMENT_COST = 2;
    private static int MECHANIC_COST = 10;
    private static int ROCKET_CAPACITY = 100;
    private static int POD_CAPACITY = 50;

    public static void generateEarth() {
        earth = new Earth();
    }

    private Earth() {
        funds = 0;
        rockets = 0;
        receptors = 0;
    }

    public long getFunds() {
        return funds;
    }

    public long getRockets() {
        return rockets;
    }

    public long getReceptors() {
        return receptors;
    }

    public void buyRocket() {
        // stub
    }

    public void buyReceptor() {
        // stub
    }

    public void launchRocket(int resources, int equipment, int mechanics) throws IllegalArgumentException {
        // stub
    }

    public void launchPod(int resources, int equipment, int mechanics) throws IllegalArgumentException {
        // stub
    }

    public void receiveFunding(long funding) {
        funds += funding;
    }
}

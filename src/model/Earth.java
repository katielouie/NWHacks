package model;

public class Earth {
    public static Earth earth;
    private long money;
    private long rockets;
    private long receptors;

    public void generateEarth() {
        earth = new Earth();
    }

    private Earth() {
        money = 0;
        rockets = 0;
        receptors = 0;
    }

    public long getMoney() {
        return money;
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

    public void launchRocket() {
        // stub
    }

    public void launchPod(){
        // stub
    }

    public void receiveFunding(long funding) {
        money += funding;
    }
}

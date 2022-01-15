package model;

public class Mercury {
    public static Mercury mercury;
    private long resources;
    private long equipment;
    private long mechanics;
    private long excavators;
    private long manufacturers;
    private long solarPanels;
    private long launchers;
    private long rockets;
    private long receptors;

    public void generateMercury() {
        mercury = new Mercury();
    }

    private Mercury() {
        resources = 0;
        equipment = 0;
        mechanics = 0;
        excavators = 0;
        manufacturers = 0;
        solarPanels = 0;
        launchers = 0;
        rockets = 0;
        receptors = 0;
    }

    public void buildExcavator() {
        //stub
    }

    public void buildManufacturer() {
        //stub
    }

    public void buildSolarPanels() {
        //stub
    }

    public void buildLauncher() {
        //stub
    }

    public void launchPanels() {
        //stub
    }

    public long getResources() {
        return resources;
    }

    public long getEquipment() {
        return equipment;
    }

    public long getMechanics() {
        return mechanics;
    }

    public long getExcavators() {
        return excavators;
    }

    public long getManufacturers() {
        return manufacturers;
    }

    public long getSolarPanels() {
        return solarPanels;
    }

    public long getLaunchers() {
        return launchers;
    }

    public long getRockets() {
        return rockets;
    }

    public long getReceptors() {
        return receptors;
    }

    public long getEnergyUse() {
        return 0; //stub
    }
}

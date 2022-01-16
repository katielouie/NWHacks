package model;

public class Mercury {
    public static Mercury mercury;
    private long resources;
    private long equipment;
    private Mechanics mechanics;
    private Excavators excavators;
    private Manufacturers manufacturers;
    private Panels panels;
    private Launchers launchers;
    private long rockets;
    private long receptors;

    public void generateMercury() {
        mercury = new Mercury();
    }

    private Mercury() {
        resources = 0;
        equipment = 0;
        mechanics = new Mechanics();
        excavators = new Excavators();
        manufacturers = new Manufacturers();
        panels = new Panels();
        launchers = new Launchers();
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

    public long getEnergyUse() {
        return 0; //stub
    }

    public long getResources() {
        return resources;
    }

    public long getEquipment() {
        return equipment;
    }

    public void setResources(long resources) {
        this.resources = resources;
    }

    public void setEquipment(long equipment) {
        this.equipment = equipment;
    }

    public Mechanics getMechanics() {
        return mechanics;
    }

    public Excavators getExcavators() {
        return excavators;
    }

    public Manufacturers getManufacturers() {
        return manufacturers;
    }

    public Panels getPanels() {
        return panels;
    }

    public Launchers getLaunchers() {
        return launchers;
    }

    public long getRockets() {
        return rockets;
    }

    public long getReceptors() {
        return receptors;
    }
}

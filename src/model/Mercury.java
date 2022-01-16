package model;

import model.infrastructure.*;

public class Mercury {
    public static Mercury mercury;
    private long resources;
    private long equipment;
    private Mechanics mechanics;
    private Excavators excavators;
    private Manufacturers manufacturers;
    private SolarPanels solarPanels;
    private Launchers launchers;
    private long spacePanels;
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
        solarPanels = new SolarPanels();
        launchers = new Launchers();
        spacePanels = 0;
        rockets = 0;
        receptors = 0;
    }

    public void buildMechanic(long n) {
        mechanics.build(n);
    }

    public void buildExcavator(long n) {
        excavators.build(n);
    }

    public void buildManufacturer(long n) {
        manufacturers.build(n);
    }

    public void buildSolarPanels(long n) {
        solarPanels.build(n);
    }

    public void buildLauncher(long n) {
        launchers.build(n);
    }

    public void launchPanels() {
        long launched = launchers.getActive() * Launchers.LAUNCH_RATE;
        if (launched > spacePanels) {
            launched = spacePanels;
        }
        spacePanels -= launched;
        Sun.sun.addPanels(launched);
    }

    public void repairInfrastructure() {
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

    public void useResources(long resources) {
        this.resources -= resources;
    }

    public void useEquipment(long equipment) {
        this.equipment -= equipment;
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

    public SolarPanels getSolarPanels() {
        return solarPanels;
    }

    public Launchers getLaunchers() {
        return launchers;
    }

    public long getSpacePanels() {
        return spacePanels;
    }

    public long getRockets() {
        return rockets;
    }

    public long getReceptors() {
        return receptors;
    }
}

package model;

import model.infrastructure.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Mercury {
    public static Mercury mercury;
    private long resources;
    private long equipment;
    private final Mechanics mechanics;
    private final SolarPanels solarPanels;
    private final Excavators excavators;
    private final Manufacturers manufacturers;
    private final Launchers launchers;
    private final ArrayList<Infrastructure> infrastructures;
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
        solarPanels = new SolarPanels();
        excavators = new Excavators();
        manufacturers = new Manufacturers();
        launchers = new Launchers();
        infrastructures = new ArrayList<>(Arrays.asList(mechanics, solarPanels, excavators, manufacturers, launchers));
        spacePanels = 0;
        rockets = 0;
        receptors = 0;
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
        long repairPoints = mechanics.getActive() * Mechanics.REPAIR_RATE;
        long totalNeeded = getRepairNeeded();
        Long portion = null;
        if (totalNeeded > repairPoints) {
            portion = repairPoints / infrastructures.size();
        }
        short i = 0;
        for (Infrastructure infrastructure : infrastructures) {
            if (portion == null) {
                infrastructure.repair();
            } else {
                long amount;
                if (i < repairPoints % infrastructures.size()) {
                    amount = portion + 1;
                } else {
                    amount = portion;
                }
                infrastructure.repair(amount);
            }
            i++;
        }
    }

    public long getRepairNeeded() {
        long totalNeeded = 0;
        for (Infrastructure infrastructure : infrastructures) {
            totalNeeded += infrastructure.getRepairNeeded();
        }
        return totalNeeded;
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

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

    public static void generateMercury() {
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
    }

    // Sets infrastructure to active constrained by user-specified maxes, energy production,
    // and resource/equipment stockpiles
    public void setActiveInfrastructure() {
        // stub
    }

    public void launchPanels() {
        long launched = launchers.getActive() * Launchers.LAUNCH_RATE;
        if (launched > spacePanels) {
            launched = spacePanels;
        }
        spacePanels -= launched;
        Sun.sun.addPanels(launched);
    }

    public void repairAndBuild() {
        long workPoints = mechanics.getActive() * Mechanics.WORK_RATE;
        long totalNeeded = getRepairNeeded();
        Long portion = null;
        if (totalNeeded > workPoints) {
            portion = workPoints / infrastructures.size();
        }
        short i = 0;
        for (Infrastructure infrastructure : infrastructures) {
            if (portion == null) {
                infrastructure.repair();
            } else {
                long amount;
                if (i < workPoints % infrastructures.size()) {
                    amount = portion + 1;
                } else {
                    amount = portion;
                }
                infrastructure.repair(amount);
            }
            i++;
        }
        workPoints -= totalNeeded;
        if (workPoints > 0) {
            build(workPoints);
        }
    }

    // Uses work points to progress building prioritizing those first in the infrastructure list
    private void build(long workPoints) {
        for (Infrastructure infrastructure : infrastructures) {
            long needed = infrastructure.getBuildNeeded();
            if (needed > workPoints) {
                infrastructure.doBuild(workPoints);
                return;
            } else {
                infrastructure.doBuild(needed);
            }
        }
    }

    public long getRepairNeeded() {
        long totalNeeded = 0;
        for (Infrastructure infrastructure : infrastructures) {
            totalNeeded += infrastructure.getRepairNeeded();
        }
        return totalNeeded;
    }

    public long getBuildNeeded() {
        long totalNeeded = 0;
        for (Infrastructure infrastructure : infrastructures) {
            totalNeeded += infrastructure.getBuildNeeded();
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

    public void addResources(long resources) {
        this.resources += resources;
    }

    public void addEquipment(long equipment) {
        this.equipment += equipment;
    }

    public void addMechanics(long n) {
        mechanics.addMechanics(n);
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
}

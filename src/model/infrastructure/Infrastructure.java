package model.infrastructure;

import model.Mercury;

import java.util.Random;

public abstract class Infrastructure {
    private final Random randomGenerator;

    protected Long maxActive;     // null if no max
    protected long active;
    protected long inactive;
    protected long broken;
    protected int repairProgress;

    // Equipment and material costs to build one unit
    private final int resourceBuildCost;
    private final int equipmentBuildCost;

    // Chance per million per day to breakdown
    private final int activeBreakdownChance;
    private final int inactiveBreakdownChance;

    // Equipment and material costs to repair one unit
    private final int materialRepairCost;
    private final int equipmentRepairCost;
    private final int labourRepairCost;

    // Energy use per unit
    private final int activeEnergyUse;
    private final int inactiveEnergyUse;

    public Infrastructure(int resourceBuildCost, int equipmentBuildCost,
                          int activeBreakdownChance, int inactiveBreakdownChance,
                          int materialRepairCost, int equipmentRepairCost, int labourRepairCost,
                          int activeEnergyUse, int inactiveEnergyUse) {
        maxActive = null;
        active = 0;
        inactive = 0;
        broken = 0;
        repairProgress = 0;
        this.resourceBuildCost = resourceBuildCost;
        this.equipmentBuildCost = equipmentBuildCost;
        this.activeBreakdownChance = activeBreakdownChance;
        this.inactiveBreakdownChance = inactiveBreakdownChance;
        this.materialRepairCost = materialRepairCost;
        this.equipmentRepairCost = equipmentRepairCost;
        this.labourRepairCost = labourRepairCost;
        this.activeEnergyUse = activeEnergyUse;
        this.inactiveEnergyUse = inactiveEnergyUse;
        randomGenerator = new Random();
    }

    public void deteriorate() {
        deteriorateActive();
        deteriorateInactive();
    }
    
    private void deteriorateActive() {
        double z = randomGenerator.nextGaussian();
        double p = activeBreakdownChance / 1_000_000.0;
        double sd = Math.sqrt(active * p * (1 - p));
        double amount = active * p + sd * z;
        if (amount < 0) {
            amount = 0;
        } else if (amount > active) {
            amount = active;
        }
        broken += amount;
        active -= amount;
    }
    
    private void deteriorateInactive() {
        double z = randomGenerator.nextGaussian();
        double p = inactiveBreakdownChance / 1_000_000.0;
        double sd = Math.sqrt(inactive * p * (1 - p));
        double amount = inactive * p + sd * z;
        if (amount < 0) {
            amount = 0;
        } else if (amount > inactive) {
            amount = inactive;
        }
        broken += amount;
        inactive -= amount;
    }

    public void build(long num) throws IllegalArgumentException {
        Mercury mercury = Mercury.mercury;
        long usedResources = resourceBuildCost * num;
        long usedEquipment = equipmentBuildCost * num;
        if (usedResources > mercury.getResources() || usedEquipment > mercury.getEquipment()) {
            throw new IllegalArgumentException("Insufficient resources");
        } else {
            mercury.useResources(usedResources);
            mercury.useEquipment(usedEquipment);
        }
    }

    public void setMaxActive(Long maxActive) {
        this.maxActive = maxActive;
    }

    public Long getMaxActive() {
        return maxActive;
    }

    public long getWorking() {
        return inactive + active;
    }

    public long getBroken() {
        return broken;
    }

    public int getResourceBuildCost() {
        return resourceBuildCost;
    }

    public int getEquipmentBuildCost() {
        return equipmentBuildCost;
    }

    public int getActiveBreakdownChance() {
        return activeBreakdownChance;
    }

    public int getInactiveBreakdownChance() {
        return inactiveBreakdownChance;
    }

    public int getMaterialRepairCost() {
        return materialRepairCost;
    }

    public int getEquipmentRepairCost() {
        return equipmentRepairCost;
    }

    public int getActiveEnergyUse() {
        return activeEnergyUse;
    }

    public int getInactiveEnergyUse() {
        return inactiveEnergyUse;
    }

    public long getActive() {
        return active;
    }

    public long getInactive() {
        return inactive;
    }
}

package model.infrastructure;

public class SolarPanels extends Infrastructure {
    // Equipment and material costs to build one robot mechanic
    private static final int RESOURCE_BUILD_COST = 1;
    private static final int EQUIPMENT_BUILD_COST = 1;

    // Chance per million per day to breakdown
    private static final int ACTIVE_BREAKDOWN_CHANCE = 100;
    private static final int INACTIVE_BREAKDOWN_CHANCE = 1;

    // Equipment and material costs to repair one robot mechanic
    private static final int RESOURCE_REPAIR_COST = 1;
    private static final int EQUIPMENT_REPAIR_COST = 3;
    private static final int LABOUR_REPAIR_COST = 1;

    // Energy use per unit
    private static final int ACTIVE_ENERGY_USE = 0;
    private static final int INACTIVE_ENERGY_USE = 0;

    public SolarPanels() {
        super(RESOURCE_BUILD_COST, EQUIPMENT_BUILD_COST,
                ACTIVE_BREAKDOWN_CHANCE, INACTIVE_BREAKDOWN_CHANCE,
                RESOURCE_REPAIR_COST, EQUIPMENT_REPAIR_COST, LABOUR_REPAIR_COST,
                ACTIVE_ENERGY_USE, INACTIVE_ENERGY_USE);
    }
}

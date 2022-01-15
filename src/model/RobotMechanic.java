package model;

public class RobotMechanic {
    // Equipment and material costs to build one robot mechanic
    public static int EQUIPMENT_BUILD_COST = 10;
    public static int MATERIAL_BUILD_COST = 10;

    // Chance per million per day to breakdown
    public static int ACTIVE_BREAKDOWN_CHANCE = 100;
    public static int INACTIVE_BREAKDOWN_CHANCE = 1;

    // Equipment and material costs to repair one robot mechanic
    public static int EQUIPMENT_REPAIR_COST = 1;
    public static int MATERIAL_REPAIR_COST = 3;

    // Energy use per unit
    public static int ACTIVE_ENERGY_USE = 1;
    public static int INACTIVE_ENERGY_USE = 0;
}

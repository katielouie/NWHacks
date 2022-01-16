package model;

import java.util.HashMap;
import java.util.Map;

public class Earth {
    public static Earth earth;
    private long funds;

    private static long INITIAL_FUNDS = 200;
    private final static int RESOURCE_COST = 1;
    private final static int EQUIPMENT_COST = 2;
    private final static int MECHANIC_COST = 10;
    private final static int POD_CAPACITY = 50;
    private final static int TRANSIT_TIME = 200;
    private final Map<Pod, Long> pods;

    public static void generateEarth() {
        earth = new Earth();
    }

    private Earth() {
        funds = INITIAL_FUNDS;
        pods = new HashMap<>();
    }

    public long getFunds() {
        return funds;
    }

    public void launchPod(int resources, int equipment, int mechanics) throws IllegalArgumentException {
        launchPod(resources, equipment, mechanics, 1);
    }

    public void launchPod(int resources, int equipment, int mechanics, int number) throws IllegalArgumentException {
        Pod pod = new Pod(resources, equipment, mechanics, TRANSIT_TIME);
        pods.put(pod, pods.getOrDefault(pod, 0L) + number);
    }

    public void tick() {
        for (Pod pod : pods.keySet()) {
            pod.tick();
            if (pod.isArrived()) {
                arrive(pod, pods.get(pod));
            }
        }
    }

    private void arrive(Pod pod, long n) {
        Mercury.mercury.addResources(pod.getResources() * n);
        Mercury.mercury.addEquipment(pod.getEquipment() * n);
        Mercury.mercury.addMechanics(pod.getMechanics() * n);
        pods.remove(pod);
    }

    public void receiveFunding(long funding) {
        funds += funding;
    }
}

package model;

import java.util.Objects;

public class Pod {
    private int resources;
    private int equipment;
    private int mechanics;
    private int eta;

    public Pod(int resources, int equipment, int mechanics, int eta) {
        this.resources = resources;
        this.equipment = equipment;
        this.mechanics = mechanics;
        this.eta = eta;
    }

    public void tick() {
        eta -= 1;
    }

    public boolean isArrived() {
        return eta <= 0;
    }

    public int getResources() {
        return resources;
    }

    public int getEquipment() {
        return equipment;
    }

    public int getMechanics() {
        return mechanics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pod pod = (Pod) o;
        return resources == pod.resources && equipment == pod.equipment && mechanics == pod.mechanics;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resources, equipment, mechanics);
    }
}

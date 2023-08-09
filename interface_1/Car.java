package org.example;
import org.example.Mechanic;
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car start");
    }

    @Override
    public void stop() {
        System.out.println("Car stop");
    }
    @Override
    public void performMaintenance(String maintenanceType) {
        Mechanic mechanic = new Mechanic();
        mechanic.doMaintenance("Car", maintenanceType);
    }
}

package org.example;
import org.example.Mechanic;
class Motorcycle implements Vehicle {
    @Override
    public void start() {
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stopped");
    }
    @Override
    public void performMaintenance(String maintenanceType) {
        Mechanic mechanic = new Mechanic();
        mechanic.doMaintenance("Motorcycle", maintenanceType);
    }
}
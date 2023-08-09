package org.example;
import java.util.HashMap;
import java.util.Map;

public class Main {
    String ab;
    public static void main(String[] args) {
        Map<String, Vehicle> vehicleMap = new HashMap<>();
        vehicleMap.put("car", new Car());
        vehicleMap.put("motorcycle", new Motorcycle());

        Vehicle car = vehicleMap.get("car");
        car.start();
        car.performMaintenance("Oil Change");
        car.stop();

        Vehicle motorcycle = vehicleMap.get("motorcycle");
        motorcycle.start();
        motorcycle.performMaintenance("Tire Rotation");
        motorcycle.stop();

    }
}

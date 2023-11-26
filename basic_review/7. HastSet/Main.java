package org.example;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("BMW");
        System.out.println(cars);
        cars.contains("Mazda");
        cars.remove("BMW");
        System.out.println(cars);
    }
}

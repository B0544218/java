package org.example;
import java.util.ArrayList;
import java.util.Collections;  // Import the Collections class

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);
        System.out.println(cars.contains("BMW")); // true

        System.out.println("Sort Result:");
        Collections.sort(cars);
        cars.remove("Fordd");
        cars.remove("Ford");
        for (int i=0; i < cars.size(); i++){
            System.out.println(cars.get(i));
        }

    }
}

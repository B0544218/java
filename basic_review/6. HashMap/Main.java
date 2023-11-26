package org.example;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) {
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        capitalCities.get("England");
        capitalCities.remove("England");

        for (String k : capitalCities.keySet()) {
            System.out.println("key: " + k + " value: " + capitalCities.get(k));
        }
    }
}

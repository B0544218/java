package org.example;
import java.util.function.BiConsumer;
import java.util.HashMap;
class MyBiConsumer implements BiConsumer<String, Integer> {
    public void accept(String k, Integer v) {
        System.out.print("Key = " + k);
        System.out.println("\t Value = " + v);
    }
}
public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("geeks", 55);
        map.put("is", 11);
        map.put("heaven", 90);

        // creating a custom action
        BiConsumer<String, Integer> action = new MyBiConsumer();
        map.forEach(action);
    }
}

package org.example;
import org.example.ArrayList;
public class Main {
    public static <T extends Comparable<T>> int compareDates(T obj1, T obj2) {
        return obj1.compareTo(obj2);
    }

    public static void main(String args[]){
        MyDate aliceDate = new MyDate(1990, 5, 15);
        MyDate bobDate = new MyDate(1985, 3, 10);

        Employee alice = new Employee("Alice", aliceDate);
        Employee bob = new Employee("Bob", bobDate);

        int comparison = compareDates(alice.getDateOfBirth(), bob.getDateOfBirth());

        if (comparison < 0) {
            System.out.println("Alice is older than Bob.");
        } else if (comparison > 0) {
            System.out.println("Bob is older than Alice.");
        } else {
            System.out.println("Alice and Bob are the same age.");
        }
    }
}

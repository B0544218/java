package org.example;
import java.util.Comparator;

public class Main {

    public static void main(String args[]){
        MyDate aliceDate = new MyDate(1990, 5, 15);
        MyDate bobDate = new MyDate(1985, 3, 10);

        Employee alice = new Employee("Alice", aliceDate);
        Employee bob = new Employee("Bob", bobDate);

        Comparator<Employee> employeeComparator = (emp1, emp2) ->
                emp1.getDateOfBirth().compareTo(emp2.getDateOfBirth());

        int comparison = employeeComparator.compare(alice, bob);

        if (comparison < 0) {
            System.out.println("Alice is older than Bob.");
        } else if (comparison > 0) {
            System.out.println("Bob is older than Alice.");
        } else {
            System.out.println("Alice and Bob are the same age.");
        }
    }
}

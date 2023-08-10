package org.example;

public class Employee {
    private String name;
    private MyDate dateOfBirth;

    public Employee(String name, MyDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public MyDate getDateOfBirth() {
        return dateOfBirth;
    }

}
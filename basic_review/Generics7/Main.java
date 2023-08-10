package org.example;
import java.util.Comparator;

public class Main {

    public static void main(String args[]){
        MyDate aliceDate = new MyDate(1990, 5, 15);
        MyDate bobDate = new MyDate(1985, 3, 10);

        Employee alice = new Employee("Alice", aliceDate);
        Employee bob = new Employee("Bob", bobDate);

//        第一種比較 (自己透過Integer.compare寫的比較)
//        int comparison = bob.getDateOfBirth().compareTo(alice.getDateOfBirth());

        
        
//        第二種比較 (透過箭頭函式)
//        我們定義了一個 Comparator<Employee> 物件，並使用 compareTo 方法比較 Employee 物件的日期。
        Comparator<Employee> employeeComparator = (emp1, emp2) ->
                emp1.getDateOfBirth().compareTo(emp2.getDateOfBirth());
//        然後，我們使用 employeeComparator 來比較 alice 和 bob 的日期。
        int comparison = employeeComparator.compare(alice, bob);

        if (comparison < 0) {
            System.out.println("Alice is younger than Bob.");
        } else if (comparison > 0) {
            System.out.println("Bob is older than Alice.");
        } else {
            System.out.println("Alice and Bob are the same age.");
        }
    }
}

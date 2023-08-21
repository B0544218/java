package org.example;
public class Main {
    //重新定義一個compareDates function，<T extends Comparable<T>>：<T> 表示這個方法可以使用一個泛型型別 。T extends Comparable<T> 限制了 T 必須實作了 Comparable 介面
    //用來確保 obj1 和 obj2可以使用comparable的compareTo方法
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

package org.example;

public class Student {
    int rollno;
    String name;
    // static 讓所有的實例都會共用同一個colleage變數
    static String college = "ITSchool";
    //static method 改變 static variable 的值
    static void change(){
        college = "AITSchool";
    }
    //constructor
    Student(int r, String n){
        rollno = r;
        name = n;
    }

    void display(){
        System.out.println(rollno+" "+name+" "+college);
    }

}

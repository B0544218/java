package org.example;
import org.example.Student;
public class Main {
    public static void main(String args[]){

        Student s1 = new Student(1,"Tom");
        Student.change();
        Student s2 = new Student(2,"Mary");
        Student s3 = new Student(3,"Ben");

        s1.display();
        s2.display();
        s3.display();
        // output，3個最後的output School都會長一樣
        //  1 Tom AITSchool
        //  2 Mary AITSchool
        //  3 Ben AITSchool

    }
}

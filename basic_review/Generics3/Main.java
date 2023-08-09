package org.example;
import org.example.ArrayList;
public class Main {
    public static void main(String args[]){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Justin");
        names.add("Monica");
        String name1 = names.get(0);
        String name2 = names.get(1);
        System.out.println(name1 + " , " + name2);
    }
}

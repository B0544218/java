package org.example;
import org.example.ArrayList;
public class Main {
    public static void main(String args[]){
        // 創建一個裝有整數的 Box
        Box<Integer> integerBox = new Box<>(42);

        // 創建一個裝有字符串的 Box
        Box<String> stringBox = new Box<>("Hello, Generics!");

        // 將整數的 Box 放入容器
        Container<Integer> integerContainer = new Container<>(integerBox);

        // 將字符串的 Box 放入容器
        Container<String> stringContainer = new Container<>(stringBox);

        // 獲取容器中整數的 Box，並取出其中的值
        Box<Integer> retrievedIntegerBox = integerContainer.getStoredBox();
        System.out.println("Retrieved Integer: " + retrievedIntegerBox.getItem());

        // 獲取容器中字符串的 Box，並取出其中的值
        Box<String> retrievedStringBox = stringContainer.getStoredBox();
        System.out.println("Retrieved String: " + retrievedStringBox.getItem());
    }
}

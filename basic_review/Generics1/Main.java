package org.example;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String args[]){
        // 創建一個存放 Item 的 Box
        Box<Item> itemBox = new Box<>();
        Item item = new Item("Book");
        itemBox.addContent(item);

        // 從 Box 中取出 Item
        Item retrievedItem = itemBox.getContent();
        System.out.println("Retrieved item: " + retrievedItem.getName());

        // 創建一個存放 String 的 Box
        Box<String> stringBox = new Box<>();
        stringBox.addContent("Hello, Generics!");

        // 從 Box 中取出 String
        String retrievedString = stringBox.getContent();
        System.out.println("Retrieved string: " + retrievedString);
    }
}

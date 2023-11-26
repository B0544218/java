package org.example;
public class Main {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static String staticNameMethod(String name) {
       return "initial"+name;
    }
    public static void main(String[] args) {
        // Create an instance of the Main class
        Main mainInstance = new Main();
        // Use the instance to call the setName method
        mainInstance.setName("John");
        // Access the name using getName
        String currentName = mainInstance.getName();
        System.out.println("Hello world! Name: " + currentName);

        String staticName = staticNameMethod("mike");
        System.out.println("Hello world! Name: " + staticName);
        staticName = staticNameMethod("json");
        System.out.println("Hello world! Name: " + staticName);
    }
}

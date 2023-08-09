package org.example;

// 定义另一个泛型类 Container，使用 Box 泛型
public class Container<T> {
    private Box<T> storedBox;

    public Container(Box<T> box) {
        this.storedBox = box;
    }

    public Box<T> getStoredBox() {
        return storedBox;
    }

    public void setStoredBox(Box<T> box) {
        this.storedBox = box;
    }
}
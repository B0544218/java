package com.example.sb0706;

public class Caculator {
    public Integer add(int x, int y){
        return x + y;
    }
    public float divide(int x, int y){
        return x / y;
    }
    public static void main(String[] args) {
        Caculator calculator = new Caculator();
        int result = calculator.add(1, 3);
        System.out.println("結果為: " + result);
    }
}

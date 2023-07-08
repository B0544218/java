package com.example.sb0706;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HpPrinter implements Printer{
    private int count;
    @Value("${printer.name}")
    private String name;
    @PostConstruct
    public void init(){
        count =5;
    }
    @Override
    public void print(String message) {
        count--;
        System.out.println("HP印表機" + message);
        System.out.println(name);
        System.out.println("剩餘印出次數: " + count);
    }
}

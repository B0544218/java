package com.example.sb0706;

import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println("HP印表機" + message);

    }
}

package com.example.sb0706;

import org.junit.jupiter.api.*;

public class MyTest {
    @BeforeEach
    public void beforeEach(){
        System.out.println("執行 @BeforeEach");
    }
    @AfterEach
    public void AfterEach(){
        System.out.println("執行 @AftereEach");
    }
    @BeforeAll
    public static void BeforeAll(){
        System.out.println("執行BeforeAll");
    }
    @AfterAll
    public static void AfterAll(){
        System.out.println("執行AfterAll");
    }
    @Test
    public void test1(){
        System.out.println("執行test1");
    }
    @Test
    public void test2(){
        System.out.println("執行test2");
    }
}

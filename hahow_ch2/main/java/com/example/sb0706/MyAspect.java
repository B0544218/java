package com.example.sb0706;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class MyAspect {
    @Before("execution(* com.example.sb0706.HpPrinter.*(..))")
    public void before(){
        System.out.println("I'm before");
    }
    @After("execution(* com.example.sb0706.HpPrinter.*(..))")
    public void after(){
        System.out.println("I'm After");
    }
}

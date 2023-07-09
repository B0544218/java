package com.example.sb0706;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/test1")
    public String test1(){
        throw new RuntimeException("Test1 error");
    }
    @RequestMapping("/test2")
    public String test2(){
        throw new IllegalArgumentException("Test2 error");
    }
}

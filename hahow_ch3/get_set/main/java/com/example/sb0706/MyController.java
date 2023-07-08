package com.example.sb0706;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/detail")
@RestController
public class MyController {
    @RequestMapping("/product")
    public Store product(){
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductList(list);
        return store;
    }
    @RequestMapping("/user")
    public Student user(){
        Student student = new Student();
        student.setName("Judy");
        System.out.println(student.getName());
        student.setId(1234);
        System.out.println(student.getId());
        return student;
    }
}
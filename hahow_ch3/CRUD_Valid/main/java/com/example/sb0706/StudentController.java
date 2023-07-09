package com.example.sb0706;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Validated
public class StudentController {
    @PostMapping("/students")
    public String create(@RequestBody @Valid Student student){
        return "執行資料庫的Create操作";
    }
    @GetMapping("/students/{studentId}")
    public String read(@PathVariable @Min(100) Integer studentId){
        return "執行資料庫的Create操作";
    }
    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student,
                         @RequestHeader String info){
        return "執行資料庫的Update操作";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId){
        return "執行資料庫的Delete操作";
    }
}

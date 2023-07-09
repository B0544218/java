package com.example.sb0706;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @PostMapping("/students")
    public String insert(@RequestBody Student student){
        // SQL的冒號(:) 表示動態變數，對應後面的Map變數
        String sql = "INSERT INTO student(id, name) VALUE (:studentId, :studentName)";
        Map<String, Object> map=new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());

        namedParameterJdbcTemplate.update(sql, map);
        return "執行INSERT sql";
    }
    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId){
        String sql = "Delete from student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        namedParameterJdbcTemplate.update(sql, map);

        return "執行DELETE sql";
    }
}

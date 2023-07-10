package com.example.sb0706.service;

import com.example.sb0706.model.Student;

public interface StudentService {

    Integer insert(Student student);

    void update(Student student);

    void deleteById(Integer id);

    Student getById(Integer id);
}

package com.example.sb0706.dao;

import com.example.sb0706.model.Student;

public interface StudentDao {

    Integer insert(Student student);

    void update(Student student);

    void deleteById(Integer id);

    Student getById(Integer id);

}

package com.example.sb0706.service;

import com.example.sb0706.Student;
import com.example.sb0706.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Integer studentId){
        return studentDao.getById(studentId);
    }
}

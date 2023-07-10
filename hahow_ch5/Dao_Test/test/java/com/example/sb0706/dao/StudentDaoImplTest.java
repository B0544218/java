package com.example.sb0706.dao;

import com.example.sb0706.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class StudentDaoImplTest {
    @Autowired
    private StudentDao studentDao;
    @Test
    public void getById() {
        Student student = studentDao.getById(1);
        assertNotNull(student);
        assertEquals("Amy", student.getName());
        assertEquals(90.3, student.getScore());
        assertTrue(student.isGraduate());
        assertNotNull(student.getCreateDate());
    }

    //  @ Transactional讓SpringBoot會去Rollback所有DB的操作
    @Transactional
    @Test
    public void deleteById(){
        studentDao.deleteById(3);

        Student student = studentDao.getById(3);
        assertNull(student);
    }




    @Test
    @Transactional
    public void insert() {
        Student student = new Student();
        student.setName("Kevin");
        student.setScore(66.2);
        student.setGraduate(true);

        Integer studentld = studentDao.insert(student);

        Student result = studentDao.getById(studentld);
        assertNotNull(result);
        assertEquals("Kevin", result.getName());
        assertEquals(66.2, result.getScore());
        assertTrue(result.isGraduate());
        assertNotNull(result.getCreateDate());
    }

    @Test
    @Transactional
    public void update() {
        Student student = studentDao.getById(3);
        student.setName("John");
        studentDao.update(student);

        Student result = studentDao.getById(3);
        assertNotNull(result);
        assertEquals("John", result.getName());
    }
}
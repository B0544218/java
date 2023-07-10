package com.example.sb0706.service;

import com.example.sb0706.dao.StudentDao;
import com.example.sb0706.model.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentDao studentDao;
    // 讓studentDao是假的bean
    @Test
    public void getById(){
        Student mockStudent = new Student();
        // mock bean塞值
        mockStudent.setId(100);
        mockStudent.setName("I'm mock");

        // 只有在student id為3的時候，假的studentDao才會去return mockStudent的object
        // Mockito.when(studentDao.getById(3)).thenReturn(mockStudent);
         Mockito.when(studentDao.getById(Mockito.any())).thenReturn(mockStudent);

        // 如果上面的Mockito只定義id為3(例如studentDao.getById(3))，則studentService只會有id為3的資料
        Student student = studentService.getById(3);
        assertNotNull(student);
        assertEquals(100, student.getId());
        assertEquals("I'm mock", student.getName());
    }
}
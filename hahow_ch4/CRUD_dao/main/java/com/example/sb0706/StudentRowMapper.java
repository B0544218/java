package com.example.sb0706;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
//      從資料庫中取得數據
        Integer a = resultSet.getInt("id");
        String b = resultSet.getString("name");
//      將數據轉為Java object
        Student student = new Student();
        student.setId(a);
        student.setName(b);

        return student;
    }
}

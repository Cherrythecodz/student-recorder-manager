package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ✅ Insert student
    public int insertStudent(Student student) {
        String sql = "INSERT INTO students (id, name, email) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, student.getId(), student.getName(), student.getEmail());
    }

    // ✅ Get all students
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                )
        );
    }

    // ✅ Delete student by id
    public int deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}

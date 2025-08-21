package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Fetch all students
    public List<Student> getAllStudents() {
        return jdbcTemplate.query(
                "SELECT * FROM students",
                new BeanPropertyRowMapper<>(Student.class)
        );
    }

    // Insert new student
    public int insertStudent(Student s) {
        return jdbcTemplate.update(
                "INSERT INTO students (name, age) VALUES (?, ?)",
                s.getName(), s.getAge()
        );
    }

    // Delete student by ID
    public int deleteStudent(int id) {
        return jdbcTemplate.update("DELETE FROM students WHERE id = ?", id);
    }
}

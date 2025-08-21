package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentDAO;
import com.example.demo.model.Student;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    // ✅ Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    // ✅ Insert a new student
    @PostMapping
    public String addStudent(@RequestBody Student student) {
        int rows = studentDAO.insertStudent(student);
        return rows > 0 ? "Student added successfully!" : "Failed to add student.";
    }

    // ✅ Delete a student by ID
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        int rows = studentDAO.deleteStudent(id);
        return rows > 0 ? "Student deleted successfully!" : "No student found with ID " + id;
    }
}

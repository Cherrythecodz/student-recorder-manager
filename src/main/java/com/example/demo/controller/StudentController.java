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
    private StudentDAO dao;

    @GetMapping
    public List<Student> getAll() {
        return dao.getAllStudents();
    }

    @PostMapping
    public String addStudent(@RequestBody Student s) {
        dao.insertStudent(s);
        return "Student added!";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        dao.deleteStudent(id);
        return "Student deleted!";
    }
}

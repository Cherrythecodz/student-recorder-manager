package com.example.demo.model;

public class Student {
    private int id;
    private String name;
    private String email;

    // ✅ No-arg constructor (required by Spring/JPA)
    public Student() {}

    // ✅ All-args constructor
    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // ✅ Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

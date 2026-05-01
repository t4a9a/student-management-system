package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String course;

    // NEW FIELDS
    private int age;
    private String phone;
    private String email;

    public Student() {}

    public Student(Long id, String name, String course, int age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    // GETTERS
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    // SETTERS
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setAge(int age) { this.age = age; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
}
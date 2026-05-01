package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // GET ALL
    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    // ADD
    @PostMapping
    public Student add(@RequestBody Student s) {
        return repo.save(s);
    }

    // UPDATE (FIXED)
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        Student existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(s.getName());
            existing.setCourse(s.getCourse());

            // ✅ IMPORTANT FIX
            existing.setAge(s.getAge());
            existing.setPhone(s.getPhone());
            existing.setEmail(s.getEmail());

            return repo.save(existing);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
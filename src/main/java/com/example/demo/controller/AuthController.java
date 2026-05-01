package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User u = repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (u != null) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }
}
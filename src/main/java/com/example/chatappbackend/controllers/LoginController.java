package com.example.chatappbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.dtos.UserDto;
//import com.example.chatappbackend.entities.UserEntity;
import com.example.chatappbackend.services.LoginService;
import com.example.chatappbackend.security.Token;

@RestController
// @RequestMapping("/auth")
// @CrossOrigin(origins = "http://localhost:5500",allowedHeaders = "*")
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping("/auth")
    public ResponseEntity</* String */Token> login(@RequestBody /* UserEntity */UserDto user) {
        return service.login(user);
    }
}
package com.example.chatappbackend.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.dtos.UserDto;
import com.example.chatappbackend.services.SignUpService;

@RestController
public class SignupController {
    private final SignUpService service;
    public SignupController(SignUpService service){
        this.service=service;
    }
    
    @PostMapping("/signup")
    public String addUserToDB(@RequestBody UserDto newUser) {
        return service.addUserToDB(newUser);
    }
}

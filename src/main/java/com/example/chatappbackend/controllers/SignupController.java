package com.example.chatappbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.dtos.UserDto;
import com.example.chatappbackend.services.SignUpService;

@RestController
public class SignupController {
    @Autowired
    private SignUpService service;

    @PostMapping("/signup")
    public String addUserToDB(@RequestBody UserDto newUser) {
        return service.addUserToDB(newUser);
    }
}

package com.example.chatappbackend.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.dtos.UserDto;
//import com.example.chatappbackend.entities.UserEntity;
import com.example.chatappbackend.services.SignUpService;

@RestController
public class SignupController {
    private SignUpService service;

    public SignupController(SignUpService service) {
        this.service = service;
    }

    @PostMapping("/signup")
    public String addUserToDB(@RequestBody /* UserEntity newUser */UserDto newUser) {// {client terefden,{"name":"","password":"","token":"","token_exp_time":""} seklinde bir data gelecek}
        return service.addUserToDB(newUser);
    }
}

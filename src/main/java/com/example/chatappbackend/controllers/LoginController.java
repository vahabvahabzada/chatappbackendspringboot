package com.example.chatappbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.dtos.UserDto;
import com.example.chatappbackend.services.LoginService;
import com.example.chatappbackend.security.Token;

@RestController
public class LoginController {
    private final  LoginService service;
    public LoginController(LoginService service){
        this.service=service;
    }

    @PostMapping("/auth")
    public ResponseEntity<Token> login(@RequestBody UserDto user) {
        return service.login(user);
    }
}
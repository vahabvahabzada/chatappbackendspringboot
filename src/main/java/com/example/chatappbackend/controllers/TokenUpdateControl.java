package com.example.chatappbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.security.Token;
import com.example.chatappbackend.services.TokenUpdateService;

@RestController
public class TokenUpdateControl {
    @Autowired
    private TokenUpdateService service;

    @GetMapping("/updatetoken")
    public ResponseEntity<Token> updateToken() {
        return service.updateToken();
    }
}

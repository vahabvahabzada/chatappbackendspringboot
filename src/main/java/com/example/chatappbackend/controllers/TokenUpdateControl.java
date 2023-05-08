package com.example.chatappbackend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.security.Token;
import com.example.chatappbackend.services.TokenUpdateService;

@RestController
public class TokenUpdateControl {
    private final TokenUpdateService service;
    public TokenUpdateControl(TokenUpdateService service){
        this.service=service;
    }

    @GetMapping("/updatetoken")
    public ResponseEntity<Token> updateToken() {
        return service.updateToken();
    }
}

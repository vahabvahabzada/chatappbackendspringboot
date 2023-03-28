package com.example.chatappbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.chatappbackend.security.JwtGenerator;
import com.example.chatappbackend.security.Token;

@Service
public class TokenUpdateService {
    @Autowired
    private JwtGenerator jwtGenerator;

    public ResponseEntity<Token> updateToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String newToken = jwtGenerator.tokenGenerateEle(authentication);
        return new ResponseEntity<Token>(new Token(newToken), HttpStatus.OK);
    }
}

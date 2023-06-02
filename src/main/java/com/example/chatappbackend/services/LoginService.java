package com.example.chatappbackend.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.chatappbackend.dtos.UserDto;
import com.example.chatappbackend.security.JwtGenerator;
import com.example.chatappbackend.security.Token;

@Service
public class LoginService {
    private final AuthenticationManager authenticationManager;
    private JwtGenerator jwtGenerator;
    public LoginService(AuthenticationManager authenticationManager,JwtGenerator jwtGenerator){
        this.authenticationManager=authenticationManager;
        this.jwtGenerator=jwtGenerator;
    }

    public ResponseEntity<Token> login(UserDto user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
        System.out.println(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.tokenGenerateEle(authentication);
        return new ResponseEntity<Token>(new Token(token), HttpStatus.OK);
    }
}
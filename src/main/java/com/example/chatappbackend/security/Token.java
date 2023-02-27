package com.example.chatappbackend.security;

import lombok.Data;

@Data
public class Token {
    private String accessToken;
    private String tokenType="Bearer ";

    public Token(String accessToken){
        this.accessToken=accessToken;
    }
}

package com.example.chatappbackend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import com.example.chatappbackend.security.JwtGenerator;
import com.example.chatappbackend.services.LdChatListService;
import com.example.chatappbackend.dtos.MessageDto;

@RestController
public class LdChatListController {
    private JwtGenerator tokenGenerator;
    private final LdChatListService ldChatListService;
    public LdChatListController(JwtGenerator jwtGenerator,LdChatListService ldChatListService){
        this.tokenGenerator=jwtGenerator;
        this.ldChatListService=ldChatListService;
    }

    @PostMapping("/ldchatlist")
    public List<MessageDto> getChatList(HttpServletRequest request) {
        String username = request.getHeader("Authorization");
        username = username.substring(7, username.length());// "Bearer tokenValue"
        username = tokenGenerator.getUsernameFromJWT(username);
        return ldChatListService.getChatList(username);
    }
}

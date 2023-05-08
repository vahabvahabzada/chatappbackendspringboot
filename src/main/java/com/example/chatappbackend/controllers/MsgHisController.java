package com.example.chatappbackend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.dtos.MessageDto;
//import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.security.JwtGenerator;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.chatappbackend.services.MsgHisService;

@RestController
public class MsgHisController {
    private JwtGenerator jwtGenerator;
    private final MsgHisService service;
    public MsgHisController(JwtGenerator jwtGenerator,MsgHisService service){
        this.jwtGenerator=jwtGenerator;
        this.service=service;
    }

    @PostMapping("/msghis")
    public List<MessageDto> getMesgHistory(HttpServletRequest request, @RequestBody String kime) {
        String username = request.getHeader("Authorization");
        username = username.substring(7);// "Bearer "
        username = jwtGenerator.getUsernameFromJWT(username);

        return service.getMesgHistory(username, kime);
    }

}

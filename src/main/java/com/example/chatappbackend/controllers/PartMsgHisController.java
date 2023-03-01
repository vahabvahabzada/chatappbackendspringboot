package com.example.chatappbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatappbackend.entities.Kime;
//import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.security.JwtGenerator;
import com.example.chatappbackend.services.PartMsgHisService;
import com.example.chatappbackend.dtos.MessageDto;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PartMsgHisController {
    @Autowired
    private JwtGenerator generator;

    @Autowired
    private PartMsgHisService service;

    @PostMapping("/msgprtlhis")
    public List</* Message */MessageDto> getNewMessages(HttpServletRequest request,
            @RequestBody /* String */ Kime kime) {
        String username = request.getHeader("Authorization");
        username = username.substring(7, username.length());// "Bearer tokenValue"
        username = generator.getUsernameFromJWT(username);
        // System.out.println(kime);
        return service.getNewMessages(username, kime.getKime());
    }
}

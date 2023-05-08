package com.example.chatappbackend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.security.JwtGenerator;
import com.example.chatappbackend.services.PartMsgHisService;
import com.example.chatappbackend.dtos.Kime;
import com.example.chatappbackend.dtos.MessageDto;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PartMsgHisController {
    private JwtGenerator generator;
    private final PartMsgHisService service;
    public PartMsgHisController(PartMsgHisService service){
        this.service=service;
    }

    @PostMapping("/msgprtlhis")
    public List<MessageDto> getNewMessages(HttpServletRequest request,@RequestBody /* String */ Kime kime) {
        String username = request.getHeader("Authorization");
        username = username.substring(7, username.length());// "Bearer tokenValue"
        username = generator.getUsernameFromJWT(username);
        return service.getNewMessages(username, kime.getKime());
    }
}

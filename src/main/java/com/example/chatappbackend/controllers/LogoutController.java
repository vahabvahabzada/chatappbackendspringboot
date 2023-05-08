package com.example.chatappbackend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.chatappbackend.services.LogoutService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LogoutController {
    private final LogoutService service;
    public LogoutController(LogoutService service){
        this.service=service;
    }

    @GetMapping("/logouturl")
    public void logout(HttpServletRequest request) {
        service.logout(request);
    }
}

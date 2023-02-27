package com.example.chatappbackend.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
@Service
public class LogoutService {
    public void logout(){
        System.out.println("########### before logout : authentication = "+SecurityContextHolder.getContext().getAuthentication());
        SecurityContextHolder.clearContext();
        System.out.println("########### after logout : authentication = "+SecurityContextHolder.getContext().getAuthentication());
    }
}

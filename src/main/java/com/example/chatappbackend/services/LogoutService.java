package com.example.chatappbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.chatappbackend.entities.BlackList;
import com.example.chatappbackend.repos.BlackListRepo;
import com.example.chatappbackend.security.JwtGenerator;


import jakarta.servlet.http.HttpServletRequest;
@Service
public class LogoutService {
    @Autowired
    private BlackListRepo blackListRepo;

    @Autowired
    private JwtGenerator jwtGenerator;


    public void logout(HttpServletRequest request){
        String token=request.getHeader("Authorization").substring(7);
        boolean expired=!(jwtGenerator.validateToken(token));
        if(!expired){
            BlackList blackListObj=new BlackList();
            blackListObj.setName(jwtGenerator.getUsernameFromJWT(token));
            blackListObj.setCustomToken(token);
            blackListObj.setExpireTime(jwtGenerator.getExpTime(token));
            blackListRepo.save(blackListObj);//logout zamani hele vaxti bitmeyen token-lari bir yere yigirig
        }
        System.out.println("########### before logout : authentication = "+SecurityContextHolder.getContext().getAuthentication());
        SecurityContextHolder.clearContext();
        System.out.println("########### after logout : authentication = "+SecurityContextHolder.getContext().getAuthentication());
    }
}

// database ucun ayrica script yazmaq olar ki vaxti kecmis cache token-leri silsin
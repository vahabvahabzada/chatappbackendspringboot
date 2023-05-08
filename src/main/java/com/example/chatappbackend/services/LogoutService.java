package com.example.chatappbackend.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.chatappbackend.entities.BlackList;
import com.example.chatappbackend.repos.BlackListRepo;
import com.example.chatappbackend.repos.UserRepo;
import com.example.chatappbackend.security.JwtGenerator;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class LogoutService {
    private final BlackListRepo blackListRepo;
    private JwtGenerator jwtGenerator;
    private final UserRepo userRepo;
    public LogoutService(BlackListRepo blackListRepo,JwtGenerator jwtGenerator,UserRepo userRepo){
        this.blackListRepo=blackListRepo;
        this.jwtGenerator=jwtGenerator;
        this.userRepo=userRepo;
    }

    public void logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        BlackList blackListObj = new BlackList();
        blackListObj.setName(jwtGenerator.getUsernameFromJWT(token));
        blackListObj.setCustomToken(token);
        blackListObj.setExpireTime(jwtGenerator.getExpTime(token));

        blackListObj.setUser(userRepo.findByName(jwtGenerator.getUsernameFromJWT(token)));

        blackListRepo.save(blackListObj);// logout zamani hele vaxti bitmeyen token-lari bir yere yigirig

        System.out.println("########### before logout : authentication = "
                + SecurityContextHolder.getContext().getAuthentication());
        SecurityContextHolder.clearContext();
        System.out.println("########### after logout : authentication = "
                + SecurityContextHolder.getContext().getAuthentication());
    }
}

// database ucun ayrica script yazmaq olar ki vaxti kecmis cache token-leri
// silsin
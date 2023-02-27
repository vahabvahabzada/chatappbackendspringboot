package com.example.chatappbackend.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.chatappbackend.dtos.UserDto;
//import com.example.chatappbackend.entities.UserEntity;
import com.example.chatappbackend.security.JwtGenerator;
import com.example.chatappbackend.security.Token;
@Service
public class LoginService{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtGenerator jwtGenerator;
    public ResponseEntity</*String*/Token> login(/*UserEntity*/UserDto user){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));//sanki bu metod gedir database -i axtarir ve eger bele bir cut varsa login-i icra edir
        SecurityContextHolder.getContext().setAuthentication(authentication); // yuxaridaki ile check edirik,username ve password duzdurse,bu setir de icra olunur ve davam erdir
        //return new ResponseEntity<String>("Login is successful",HttpStatus.OK);
        String token=jwtGenerator.tokenGenerateEle(authentication);
        return new ResponseEntity<Token>(new Token(token),HttpStatus.OK);
    }
}
// generate olunmus token-i uygun user ucun users table-a (database-e) save etmek lazimdi
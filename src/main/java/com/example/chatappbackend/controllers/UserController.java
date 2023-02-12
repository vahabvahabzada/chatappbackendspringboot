package com.example.chatappbackend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.chatappbackend.entities.User;
import com.example.chatappbackend.services.UserService;
@RestController
@RequestMapping("/users")
public class UserController{
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    
    @GetMapping
    public List<User> getTargetUser(@RequestParam(value="name") String name){
        return userService.getTargetUser(name);
    }

    @PostMapping
    public User addUserToDB(@RequestBody User newUser){
        return userService.addUserToDB(newUser);
    }
}

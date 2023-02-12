package com.example.chatappbackend.services;

import org.springframework.stereotype.Service;

import com.example.chatappbackend.repos.UserRepository;
import com.example.chatappbackend.entities.User;
import java.util.List;
@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getTargetUser(String name){
        return userRepository.findByName(name);
    }
    public User addUserToDB(User newUser){
        return userRepository.save(newUser);
    }
}

package com.example.chatappbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatappbackend.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Long>{
    public UserEntity findByName(String name);
}

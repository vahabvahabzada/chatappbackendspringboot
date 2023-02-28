package com.example.chatappbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatappbackend.entities.BlackList;

public interface BlackListRepo extends JpaRepository<BlackList,Long>{
    public BlackList findByCustomToken(String token);
}

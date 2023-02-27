package com.example.chatappbackend.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatappbackend.entities.Message;

public interface MessageRepo extends JpaRepository<Message,Long>{
}

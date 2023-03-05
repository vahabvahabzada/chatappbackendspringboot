package com.example.chatappbackend.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.chatappbackend.entities.UserEntity;

public interface SignUpRepo extends CrudRepository<UserEntity, Long> {
    public UserEntity findByName(String name);
}

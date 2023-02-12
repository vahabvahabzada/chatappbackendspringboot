package com.example.chatappbackend.repos;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.chatappbackend.entities.User;
public interface UserRepository extends CrudRepository<User,Long>{
    List<User> findByName(String name);
}

package com.example.chatappbackend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.chatappbackend.entities.UserEntity;

public interface SearchRepo extends JpaRepository<UserEntity, Long> {
    // @Query(value="SELECT name FROM users where name like :searchText%",nativeQuery = true)
    // public List<String> istifadeciAxtar(@Param(value="searchText") String searchText);

    @Query("SELECT e.name FROM UserEntity e where name like ?1%") // JPQL
    public List<String> istifadeciAxtar(String searchText);
}

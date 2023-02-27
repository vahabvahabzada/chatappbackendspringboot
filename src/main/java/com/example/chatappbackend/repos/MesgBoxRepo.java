package com.example.chatappbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatappbackend.entities.MesgBox;

public interface MesgBoxRepo extends JpaRepository<MesgBox,Long>{
    public MesgBox findByMesgCouple(String mesgCouple);
}

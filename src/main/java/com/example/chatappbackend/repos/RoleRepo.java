package com.example.chatappbackend.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chatappbackend.entities.Role;

public interface RoleRepo extends JpaRepository<Role,Long>{
    public Role findRoleByName(String name);
}

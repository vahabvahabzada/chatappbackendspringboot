package com.example.chatappbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // it means that it will be mapping to db
@Table(name="users")
@Data //to create getters and setters automatically
public class User {
    @Id
    private Long id;

    private String name;
    private String password;
    private String token;
    private Long token_exp_time;
}

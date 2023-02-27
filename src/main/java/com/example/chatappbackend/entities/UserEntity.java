package com.example.chatappbackend.entities;


import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

@Entity // it means that it will be mapping to db
@NoArgsConstructor
@Data
@Table(name="users")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 1,2,3,4
    private Long id;

    private String name;
    private String password;
    //private String token;
    //private Long token_exp_time;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();
}

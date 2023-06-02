package com.example.chatappbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //it will be map to databse
@NoArgsConstructor
@Data
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mesgId;

    private String mfrom;
    private String mbody;
    private String mto;


    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;
}

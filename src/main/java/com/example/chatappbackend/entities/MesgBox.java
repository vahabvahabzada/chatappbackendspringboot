package com.example.chatappbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="mesgbox")
public class MesgBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mesg_box_id;
    private String mesgCouple;
}

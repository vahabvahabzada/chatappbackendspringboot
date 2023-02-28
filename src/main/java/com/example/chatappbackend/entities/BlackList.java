package com.example.chatappbackend.entities;

import java.util.Date;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Data
@Table(name="blacklist")
@AllArgsConstructor
@NoArgsConstructor
public class BlackList {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long b_id;

    private String name;
    private String customToken;
    private Date expireTime;
}

package com.example.chatappbackend.entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "mesgboxcorrespondence", joinColumns = @JoinColumn(name = "mesgId", referencedColumnName = "mesgId"),
            inverseJoinColumns = @JoinColumn(name = "mesg_box_id", referencedColumnName = "mesg_box_id"))

    private List<MesgBox> mesgBox=new ArrayList<>();
}

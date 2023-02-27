package com.example.chatappbackend.dtos;

import lombok.Data;

@Data
public class MessageDto {
    private String mfrom;
    private String mbody;
    private String mto;
}

package com.example.chatappbackend.services;

import org.springframework.stereotype.Service;

import com.example.chatappbackend.dtos.MessageDto;
import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.repos.MessageRepo;
import com.example.chatappbackend.repos.UserRepo;

@Service
public class MessageService {
    private final MessageRepo messageRepo;
    private final UserRepo userRepo;
    public MessageService(MessageRepo messageRepo,UserRepo userRepo){
        this.messageRepo=messageRepo;
        this.userRepo=userRepo;
    }

    public void sendMessage(MessageDto mesaj) {
        Message message = new Message();
        message.setMfrom(mesaj.getMfrom());
        message.setMbody(mesaj.getMbody());
        message.setMto(mesaj.getMto());

        message.setUser(userRepo.findByName(message.getMfrom()));
        messageRepo.save(message);
    }
}

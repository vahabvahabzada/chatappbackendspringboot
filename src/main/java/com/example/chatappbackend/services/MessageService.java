package com.example.chatappbackend.services;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.example.chatappbackend.dtos.MessageDto;
import com.example.chatappbackend.entities.MesgBox;
import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.repos.MesgBoxRepo;
import com.example.chatappbackend.repos.MessageRepo;

@Service
public class MessageService {
    private final MessageRepo messageRepo;
    private final MesgBoxRepo mesgBoxRepo;
    public MessageService(MessageRepo messageRepo,MesgBoxRepo mesgBoxRepo){
        this.messageRepo=messageRepo;
        this.mesgBoxRepo=mesgBoxRepo;
    }

    public void sendMessage(MessageDto mesaj) {
        Message message = new Message();
        message.setMfrom(mesaj.getMfrom());
        message.setMbody(mesaj.getMbody());
        message.setMto(mesaj.getMto());

        if (mesgBoxRepo.findByMesgCouple(mesaj.getMfrom() + "and" + mesaj.getMto()) == null && mesgBoxRepo.findByMesgCouple(mesaj.getMto() + "and" + mesaj.getMfrom()) == null) {
            // yeni hele yazismayiblar,couple adini cedvele elave et
            MesgBox mesgBox = new MesgBox();
            mesgBox.setMesgCouple(mesaj.getMfrom() + "and" + mesaj.getMto());
            mesgBoxRepo.save(mesgBox);
        }

        if (mesgBoxRepo.findByMesgCouple(mesaj.getMfrom() + "and" + mesaj.getMto()) != null) {
            MesgBox mesgBoxItems = mesgBoxRepo.findByMesgCouple(mesaj.getMfrom() + "and" + mesaj.getMto());
            message.setMesgBox(Collections.singletonList(mesgBoxItems));
            messageRepo.save(message);
        }
        if (mesgBoxRepo.findByMesgCouple(mesaj.getMto() + "and" + mesaj.getMfrom()) != null) {
            MesgBox mesgBoxItems = mesgBoxRepo.findByMesgCouple(mesaj.getMto() + "and" + mesaj.getMfrom());
            message.setMesgBox(Collections.singletonList(mesgBoxItems));
            messageRepo.save(message);
        }
    }
}

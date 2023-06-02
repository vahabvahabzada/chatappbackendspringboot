package com.example.chatappbackend.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.chatappbackend.repos.MsgHisRepo;
import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.dtos.MessageDto;

@Service
public class MsgHisService {
    public final MsgHisRepo msgHisRepo;
    public MsgHisService(MsgHisRepo msgHisRepo){
        this.msgHisRepo=msgHisRepo;
    }

    public List<MessageDto> getMesgHistory(String kimden, String kime) {
        List<Message> messages=msgHisRepo.getMessageHistory(kimden, kime);
        List<MessageDto> res=new LinkedList<>();
        for(Message message:messages){
            res.add(entityToDto(message));
        }
        return res;
    }

    public MessageDto entityToDto(Message mesaj) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMfrom(mesaj.getMfrom());
        messageDto.setMbody(mesaj.getMbody());
        messageDto.setMto(mesaj.getMto());
        return messageDto;
    }
}

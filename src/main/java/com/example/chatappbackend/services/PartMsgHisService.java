package com.example.chatappbackend.services;

import org.springframework.stereotype.Service;
import com.example.chatappbackend.repos.PartMsgHisRepo;
import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.dtos.MessageDto;

import java.util.LinkedList;
import java.util.List;
@Service
public class PartMsgHisService {
    private final PartMsgHisRepo partMsgHisRepo;
    public PartMsgHisService(PartMsgHisRepo partMsgHisRepo){
        this.partMsgHisRepo=partMsgHisRepo;
    }

    public List<MessageDto> getNewMessages(String kimden,String kime){
        List<Message> messages=partMsgHisRepo.getLatestMessages(kimden, kime);
        List<MessageDto> res=new LinkedList<>();
        for(Message message:messages){
            res.add(entityToDto(message));
        }
        return res;
    }

    public MessageDto entityToDto(Message mesaj){
        MessageDto mesgDto=new MessageDto();
        mesgDto.setMfrom(mesaj.getMfrom());
        mesgDto.setMbody(mesaj.getMbody());
        mesgDto.setMto(mesaj.getMto());
        return mesgDto;
    }
}

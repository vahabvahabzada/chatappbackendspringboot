package com.example.chatappbackend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.chatappbackend.repos.MesgBoxRepo;
import com.example.chatappbackend.repos.MsgHisRepo;
import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.dtos.MessageDto;

@Service
public class MsgHisService {
    private MesgBoxRepo mesgBoxRepo;
    private MsgHisRepo msgHisRepo;
    public MsgHisService(MesgBoxRepo mesgBoxRepo,MsgHisRepo msgHisRepo){
        this.mesgBoxRepo=mesgBoxRepo;
        this.msgHisRepo=msgHisRepo;
    }

    public List<MessageDto> getMesgHistory(String kimden, String kime) {
        if (mesgBoxRepo.findByMesgCouple(kimden + "and" + kime) != null) {
            Long mesgBoxId = mesgBoxRepo.findByMesgCouple(kimden + "and" + kime).getMesg_box_id();
            List<Message> mesajlar = msgHisRepo.findByMesgId(mesgBoxId);
            List<MessageDto> mesgDtos = mesajlar.stream().map(m -> mapToDto(m)).collect(Collectors.toList());
            return mesgDtos;
        }
        if (mesgBoxRepo.findByMesgCouple(kime + "and" + kimden) != null) {
            Long mesgBoxId = mesgBoxRepo.findByMesgCouple(kime + "and" + kimden).getMesg_box_id();
            List<Message> mesajlar = msgHisRepo.findByMesgId(mesgBoxId);
            List<MessageDto> mesgDtos = mesajlar.stream().map(msg -> mapToDto(msg)).collect(Collectors.toList());
            return mesgDtos;
        }
        return null; // hec yazismayiblar
    }

    public MessageDto mapToDto(Message mesaj) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMfrom(mesaj.getMfrom());
        messageDto.setMbody(mesaj.getMbody());
        messageDto.setMto(mesaj.getMto());
        return messageDto;
    }
}

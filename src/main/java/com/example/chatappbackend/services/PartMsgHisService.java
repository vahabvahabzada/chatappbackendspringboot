package com.example.chatappbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chatappbackend.repos.MesgBoxRepo;
import com.example.chatappbackend.repos.PartMsgHisRepo;
import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.dtos.MessageDto;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PartMsgHisService {
    @Autowired
    private MesgBoxRepo mesgBoxRepo;

    @Autowired
    private PartMsgHisRepo partMsgHisRepo;

    public List</*Message*/MessageDto> getNewMessages(String kimden,String kime){
        if(mesgBoxRepo.findByMesgCouple(kime+"and"+kimden)!=null){
            Long mesgBoxId=mesgBoxRepo.findByMesgCouple(kime+"and"+kimden).getMesg_box_id();
            System.out.println(mesgBoxId);
            List<Message> mesajlar=partMsgHisRepo.getLatestMessages(mesgBoxId);
            List<MessageDto> msgdtos=mesajlar.stream().map(m->mapToDto(m)).collect(Collectors.toList());
            return msgdtos;
        }
        if(mesgBoxRepo.findByMesgCouple(kimden+"and"+kime)!=null){
            Long mesgBoxId=mesgBoxRepo.findByMesgCouple(kimden+"and"+kime).getMesg_box_id();
            List<Message> mesajar=partMsgHisRepo.getLatestMessages(mesgBoxId);
            List<MessageDto> msgdtos=mesajar.stream().map(m->mapToDto(m)).collect(Collectors.toList());
            System.out.println(mesgBoxId);
            return msgdtos;
        }
        return null;//hec yazismayiblar
    }

    public MessageDto mapToDto(Message mesaj){
        MessageDto mesgDto=new MessageDto();
        mesgDto.setMfrom(mesaj.getMfrom());
        mesgDto.setMbody(mesaj.getMbody());
        mesgDto.setMto(mesaj.getMto());
        return mesgDto;
    }
}

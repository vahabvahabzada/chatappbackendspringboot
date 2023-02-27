package com.example.chatappbackend.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.chatappbackend.repos.LdChatListRepo;
import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.dtos.MessageDto;
@Service
public class LdChatListService {
    @Autowired
    private LdChatListRepo ldChatListRepo;

    public List</*Message*/MessageDto> getChatList(String currentUserName){
        if(ldChatListRepo.getAllByLikeCoupleName(currentUserName+"and")!=null){
            List<Long> mesgBoxItems=ldChatListRepo.getAllByLikeCoupleName(currentUserName+"and");
            //List<Long> mesgBoxIds;
            List<Message> messagePreviews=new ArrayList<>();
            System.out.println(mesgBoxItems);
            for(int i=0;i<mesgBoxItems.size();i++){
                System.out.println("inside loop");
                messagePreviews.add(ldChatListRepo.getLatestMessage(mesgBoxItems.get(i)));
            }
            List<MessageDto> msgPreviewDtos=messagePreviews.stream().map(m->mapToDto(m)).collect(Collectors.toList());
            return msgPreviewDtos;
        }
        if(ldChatListRepo.getAllByLikeCoupleName("and"+currentUserName)!=null){
            List<Long> mesgBoxItems=ldChatListRepo.getAllByLikeCoupleName("and"+currentUserName);
            List<Message> messagePreviews=new ArrayList<>();
            System.out.println(mesgBoxItems);
            for(int i=0;i<mesgBoxItems.size();i++){
                System.out.println("inside loop");
                messagePreviews.add(ldChatListRepo.getLatestMessage(mesgBoxItems.get(i)));
            }
            List<MessageDto> msgPreviewDtos=messagePreviews.stream().map(m->mapToDto(m)).collect(Collectors.toList());
            return msgPreviewDtos;
        }
        return null;//demeli hec kimle yazismayib
    }
    public MessageDto mapToDto(Message mesaj){
        MessageDto mesgDto=new MessageDto();
        mesgDto.setMfrom(mesaj.getMfrom());
        mesgDto.setMbody(mesaj.getMbody());
        mesgDto.setMto(mesaj.getMto());
        return mesgDto; 
    }
}

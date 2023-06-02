package com.example.chatappbackend.services;

import java.util.List;
import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.example.chatappbackend.repos.LdChatListRepo;
import com.example.chatappbackend.entities.Message;
import com.example.chatappbackend.dtos.MessageDto;

@Service
public class LdChatListService {
    private final LdChatListRepo ldChatListRepo;
    public LdChatListService(LdChatListRepo repo){
        this.ldChatListRepo=repo;
    }

    public List<MessageDto> getChatList(String currentUserName) {
        List<String> boxMans=ldChatListRepo.getBoxMans(currentUserName);
        List<MessageDto> chatList=new LinkedList<>();
        
        for(String targetUserName:boxMans){
            chatList.add(entityToDto(ldChatListRepo.getLatestMessage(currentUserName, targetUserName)));
        }
        return chatList;
    }

    public MessageDto entityToDto(Message mesaj) {
        MessageDto mesgDto = new MessageDto();
        mesgDto.setMfrom(mesaj.getMfrom());
        mesgDto.setMbody(mesaj.getMbody());
        mesgDto.setMto(mesaj.getMto());
        return mesgDto;
    }
}

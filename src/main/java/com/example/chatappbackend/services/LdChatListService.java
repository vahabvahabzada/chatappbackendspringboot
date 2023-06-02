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
        Message temp1,temp2;
        for(String targetUserName:boxMans){
            temp1=ldChatListRepo.getLatestMessage(currentUserName, targetUserName);
            temp2=ldChatListRepo.getLatestMessage(targetUserName, currentUserName);
            if(temp1==null){
                chatList.add(entityToDto(temp2));
                continue;
            }
            if(temp2==null){
                chatList.add(entityToDto(temp1));
                continue;
            }

            if(temp1.getMesgId()>temp2.getMesgId()){
                chatList.add(entityToDto(temp1));
            }
            if(temp1.getMesgId()<temp2.getMesgId()){
                chatList.add(entityToDto(temp2));
            }
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

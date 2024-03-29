package com.example.chatappbackend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.chatappbackend.entities.Message;

public interface LdChatListRepo extends JpaRepository<Message, Long> {
    
    @Query(value = "(select mfrom from messages where mto=?1) union (select mto from messages where mfrom=?1)",nativeQuery = true)
    public List<String> getBoxMans(String currentUser);

    @Query(value = "(select * from messages where mfrom=?1 and mto=?2) union (select * from messages where mfrom=?2 and mto=?1) order by mesg_id desc limit 1",nativeQuery = true)
    public Message getLatestMessage(String from,String to);
}

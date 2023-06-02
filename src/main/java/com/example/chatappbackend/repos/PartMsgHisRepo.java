package com.example.chatappbackend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.chatappbackend.entities.Message;

public interface PartMsgHisRepo extends JpaRepository<Message,Long>{
    
    @Query(value = "select * from messages where mfrom=?1 and mto=?2 order by mesg_id desc limit 1",nativeQuery = true)
    public List<Message> getLatestMessages(String mfrom,String mto);
}

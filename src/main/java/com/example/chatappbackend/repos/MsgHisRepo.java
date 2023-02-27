package com.example.chatappbackend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.chatappbackend.entities.Message;

public interface MsgHisRepo extends JpaRepository<Message,Long>{
    //@Query("select * from messages where ")
    //public List<Message> findByMesgCouple(String mesgCoupleName);
    
    @Query(value="select messages.mesg_id,mbody,mfrom,mto,mesg_box_id from messages inner join mesgboxcorrespondence on messages.mesg_id=mesgboxcorrespondence.mesg_id where mesg_box_id=?",nativeQuery=true)
    public List<Message> findByMesgId(Long mesgBoxId);
}

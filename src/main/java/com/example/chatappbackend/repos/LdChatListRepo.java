package com.example.chatappbackend.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.chatappbackend.entities.Message;

public interface LdChatListRepo extends JpaRepository<Message, Long> {
    @Query(value = "select mesg_box_id from mesgbox where mesg_couple like %?%", nativeQuery = true)
    public List<Long> getAllByLikeCoupleName(String coupleName);// Message obyekti kimi goturmek istesek default column name-ler Message entity-sinin field name-leri ile ust-uste dusmelidi

    @Query(value = "select messages.mesg_id,mbody,mfrom,mto from messages inner join mesgboxcorrespondence on messages.mesg_id=mesgboxcorrespondence.mesg_id where mesg_box_id=? order by messages.mesg_id desc limit 1", nativeQuery = true)
    public Message getLatestMessage(Long mesgBoxId);
}

package com.astra.getyourmusic.repository.chatRepository;

import com.astra.getyourmusic.model.chatSystem.Message;
import com.astra.getyourmusic.model.mediaSystem.Following;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverId(Long receiverId);
    List<Message> findBySenderId(Long senderId);
}

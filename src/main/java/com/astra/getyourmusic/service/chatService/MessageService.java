package com.astra.getyourmusic.service.chatService;

import com.astra.getyourmusic.model.chatSystem.Message;
import com.astra.getyourmusic.model.mediaSystem.Following;

import java.util.List;

public interface MessageService {
    Message getById(Long id);
    List<Message> getAllByReceiverId(Long receiverId);
    List<Message> getAllBySenderId(Long senderId);
    Message save(Message message, Long senderId, Long receiverId);
}

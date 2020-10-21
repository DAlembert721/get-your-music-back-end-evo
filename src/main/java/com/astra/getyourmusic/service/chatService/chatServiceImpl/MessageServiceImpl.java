package com.astra.getyourmusic.service.chatService.chatServiceImpl;

import com.astra.getyourmusic.model.chatSystem.Message;
import com.astra.getyourmusic.repository.chatRepository.MessageRepository;
import com.astra.getyourmusic.repository.userRepository.NotificationRepository;
import com.astra.getyourmusic.repository.userRepository.ProfileRepository;
import com.astra.getyourmusic.service.chatService.MessageService;
import com.astra.getyourmusic.service.userService.userServiceImpl.ObserverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    private final LocalDate today = LocalDate.now();

    @Override
    public Message getById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Message> getAllByReceiverId(Long receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }

    @Override
    public List<Message> getAllBySenderId(Long senderId) {
        return messageRepository.findBySenderId(senderId);
    }

    @Override
    public Message save(Message message, Long senderId, Long receiverId) {
        Message newMessage = new Message();
        newMessage.setText(message.getText());
        newMessage.setSendDate(today.toString());
        newMessage.setSender(profileRepository.findById(senderId).orElse(null));
        newMessage.setReceiver(profileRepository.findById(receiverId).orElse(null));
        newMessage.addObserver(new ObserverImpl(this.notificationRepository));
        newMessage.notifyObservers();
        return messageRepository.save(newMessage);
    }
}

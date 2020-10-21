package com.astra.getyourmusic.service.userService.userServiceImpl;

import com.astra.getyourmusic.model.userSystem.Notification;
import com.astra.getyourmusic.repository.userRepository.NotificationRepository;
import com.astra.getyourmusic.service.userService.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAllNotificationsByProfileId(Long profileId) {
        return notificationRepository.findByProfileId(profileId);
    }
}

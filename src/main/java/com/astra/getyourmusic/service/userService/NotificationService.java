package com.astra.getyourmusic.service.userService;

import com.astra.getyourmusic.model.userSystem.Notification;

import java.util.List;

public interface NotificationService {
    public List<Notification> getAllNotificationsByProfileId(Long profileId);
}

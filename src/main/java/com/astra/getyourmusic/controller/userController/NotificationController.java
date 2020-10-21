package com.astra.getyourmusic.controller.userController;

import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.model.userSystem.Notification;
import com.astra.getyourmusic.resource.userResource.MusicianResource;
import com.astra.getyourmusic.resource.userResource.NotificationResource;
import com.astra.getyourmusic.service.userService.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NotificationController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/profiles/{profileId}/notifications")
    public List<NotificationResource> getAllNotificationsByProfileId(@PathVariable(name = "profileId") Long profileId) {
        List<Notification> notifications = notificationService.getAllNotificationsByProfileId(profileId);
        return notifications.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    public NotificationResource convertToResource(Notification entity) {
        return mapper.map(entity, NotificationResource.class);
    }
}

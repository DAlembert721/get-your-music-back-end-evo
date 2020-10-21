package com.astra.getyourmusic.repository.userRepository;

import com.astra.getyourmusic.model.userSystem.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    public List<Notification> findByProfileId(Long profileId);
}

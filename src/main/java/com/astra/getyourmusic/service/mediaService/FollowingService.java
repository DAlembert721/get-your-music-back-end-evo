package com.astra.getyourmusic.service.mediaService;

import com.astra.getyourmusic.model.mediaSystem.Following;

import java.util.List;

public interface FollowingService {
    List<Following> getAllFollowedByFollowerId(Long followerId);
    Following save(Long followerId, Long followedId);
    void delete(Long followerId, Long followedId);
}

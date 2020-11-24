package com.astra.getyourmusic.repository.mediaRepository;

import com.astra.getyourmusic.model.mediaSystem.Following;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowingRepository extends JpaRepository<Following, Long> {
    List<Following> findByFollowerId(Long followerId);
    Following findByFollowerIdAndFollowedId(Long followerId, Long followedId);
}

package com.astra.getyourmusic.service.mediaService.mediaServiceImpl;

import com.astra.getyourmusic.model.mediaSystem.Following;
import com.astra.getyourmusic.repository.mediaRepository.FollowingRepository;
import com.astra.getyourmusic.repository.userRepository.MusicianRepository;
import com.astra.getyourmusic.repository.userRepository.NotificationRepository;
import com.astra.getyourmusic.service.userService.userServiceImpl.ObserverImpl;
import com.astra.getyourmusic.service.mediaService.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingServiceImpl implements FollowingService {
    @Autowired
    private FollowingRepository followingRepository;
    @Autowired
    private MusicianRepository musicianRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Following> getAllFollowedByFollowerId(Long followerId) {
        return followingRepository.findByFollowerId(followerId);
    }

    @Override
    public Following save(Long followerId, Long followedId) {
        Following exist = followingRepository.findByFollowerIdAndFollowedId(followerId, followedId);
        if(exist != null)
        {
            return null;
        }
        Following newFollowing = new Following();
        newFollowing.setFollower(musicianRepository.findById(followerId).orElse(null));
        newFollowing.setFollowed(musicianRepository.findById(followedId).orElse(null));
        newFollowing.setActive(true);
        newFollowing.addObserver(new ObserverImpl(this.notificationRepository));
        newFollowing.notifyObservers();
        return followingRepository.save(newFollowing);
    }

    @Override
    public void delete(Long followerId, Long followedId) {
        Following following = followingRepository.findByFollowerIdAndFollowedId(followerId, followedId);
        followingRepository.delete(following);
    }
}

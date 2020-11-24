package com.astra.getyourmusic.controller.mediaController;

import com.astra.getyourmusic.model.mediaSystem.Comment;
import com.astra.getyourmusic.model.mediaSystem.Following;
import com.astra.getyourmusic.resource.mediaResource.CommentResource;
import com.astra.getyourmusic.resource.mediaResource.FollowingResource;
import com.astra.getyourmusic.resource.mediaSaveResource.SaveCommentResource;
import com.astra.getyourmusic.service.mediaService.FollowingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FollowingController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private FollowingService followingService;

    @PostMapping("/musicians/{followerId}/musicians/{followedId}/following")
    private FollowingResource create(@PathVariable(name = "followerId") Long followerId,
                                     @PathVariable(name = "followedId") Long followedId)
    {
        Following newFollowing = followingService.save(followerId, followedId);
        return convertToResource(newFollowing);
    }

    @GetMapping("/musicians/{followerId}/followed")
    private List<FollowingResource> getAllFollowedByFollowerId(@PathVariable(name = "followerId") Long followerId)
    {
        List<Following> followings = followingService.getAllFollowedByFollowerId(followerId);
        return followings.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @DeleteMapping("/musicians/{followerId}/musicians/{followedId}/following")
    private void delete(@PathVariable(name = "followerId") Long followerId,
                        @PathVariable(name = "followedId") Long followedId)
    {
        followingService.delete(followerId, followedId);
    }

    @PostConstruct
    public void init(){
        mapper.addMappings(new PropertyMap<Following, FollowingResource>() {

            @Override
            protected void configure() {
                map().setFollowerId(source.getFollower().getId());
                map().setFollowerName(source.getFollower().getFirstName());
                map().setFollowedId(source.getFollowed().getId());
                map().setFollowedName(source.getFollowed().getFirstName());
            }
        });
    }

    public FollowingResource convertToResource(Following entity) {
        return mapper.map(entity, FollowingResource.class);
    }
}

package com.astra.getyourmusic.resource.mediaResource;

import lombok.Data;

@Data
public class FollowingResource {
    private Long followerId;
    private String followerName;
    private Long followedId;
    private String followedName;
}

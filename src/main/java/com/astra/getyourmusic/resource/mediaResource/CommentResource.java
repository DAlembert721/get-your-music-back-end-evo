package com.astra.getyourmusic.resource.mediaResource;

import com.astra.getyourmusic.model.mediaSystem.Comment;
import com.astra.getyourmusic.model.mediaSystem.Publication;
import com.astra.getyourmusic.model.userSystem.Profile;
import lombok.*;

import javax.persistence.*;

@Data
public class CommentResource {
    private Long id;
    private String text;
    private String commenterName;
    private String commenterLastName;
}

/*
    @PostConstruct
    public void init(){
        modelMapper.addMappings(new PropertyMap<Comment, CommentResource>() {

            @Override
            protected void configure() {
                map().setCommenterName(source.getCommenter().getFirstName());
            }
        });
    }
    //mapAutomatic
    public CommentResource convertToResource(Comment comment) {
        return modelMapper.map(comment, CommentResource.class);

    }

    public Comment convertToEntity(CommentResource commentResource) {
        return modelMapper.map(commentResource, Comment.class);

    }*/
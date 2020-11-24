package com.astra.getyourmusic.controller.mediaController;

import com.astra.getyourmusic.model.mediaSystem.Comment;
import com.astra.getyourmusic.model.mediaSystem.Publication;
import com.astra.getyourmusic.resource.mediaResource.CommentResource;
import com.astra.getyourmusic.resource.mediaResource.PublicationResource;
import com.astra.getyourmusic.resource.mediaSaveResource.SaveCommentResource;
import com.astra.getyourmusic.resource.mediaSaveResource.SavePublicationResource;
import com.astra.getyourmusic.service.mediaService.CommentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CommentService commentService;

    @GetMapping("/publications/{publicationId}/comments")
    public List<CommentResource> getAllCommentsByPublicationId(@PathVariable(name = "publicationId") Long publicationId)
    {
        List<Comment> comments = commentService.getAllCommentsByPublicationId(publicationId);
        return comments.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PostMapping("/publications/{publicationId}/profiles/{commenterId}/comments")
    public CommentResource create(@RequestBody SaveCommentResource comment,
                          @PathVariable(name = "publicationId") Long publicationId,
                          @PathVariable(name = "commenterId") Long commenterId)
    {
        Comment newComment = commentService.save(convertToEntity(comment), publicationId, commenterId);
        return convertToResource(newComment);
    }

    @PostConstruct
    public void init(){
        mapper.addMappings(new PropertyMap<Comment, CommentResource>() {

            @Override
            protected void configure() {
                map().setCommenterName(source.getCommenter().getFirstName());
                map().setCommenterLastName(source.getCommenter().getLastName());
            }
        });
    }

    public CommentResource convertToResource(Comment entity) {
        return mapper.map(entity, CommentResource.class);
    }

    public Comment convertToEntity(SaveCommentResource resource) {
        return mapper.map(resource, Comment.class);
    }
}

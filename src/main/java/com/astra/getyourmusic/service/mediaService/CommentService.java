package com.astra.getyourmusic.service.mediaService;

import com.astra.getyourmusic.model.mediaSystem.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentsByPublicationId(Long publicationId);
    Comment save(Comment comment, Long publicationId, Long commenterId);
}

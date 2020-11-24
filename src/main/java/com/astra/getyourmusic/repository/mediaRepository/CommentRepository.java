package com.astra.getyourmusic.repository.mediaRepository;

import com.astra.getyourmusic.model.mediaSystem.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPublicationId(Long publicationId);
}

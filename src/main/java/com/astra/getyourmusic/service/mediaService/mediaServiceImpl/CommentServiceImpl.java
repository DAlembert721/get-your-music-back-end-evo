package com.astra.getyourmusic.service.mediaService.mediaServiceImpl;

import com.astra.getyourmusic.model.mediaSystem.Comment;
import com.astra.getyourmusic.repository.mediaRepository.CommentRepository;
import com.astra.getyourmusic.repository.mediaRepository.PublicationRepository;
import com.astra.getyourmusic.repository.userRepository.NotificationRepository;
import com.astra.getyourmusic.service.userService.userServiceImpl.ObserverImpl;
import com.astra.getyourmusic.service.mediaService.CommentService;
import com.astra.getyourmusic.repository.userRepository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Comment> getAllCommentsByPublicationId(Long publicationId) {
        return commentRepository.findByPublicationId(publicationId);
    }

    @Override
    public Comment save(Comment comment, Long publicationId, Long commenterId) {
        Comment newComment = new Comment();
        newComment.setText(comment.getText());
        newComment.setPublication(publicationRepository.findById(publicationId).orElse(null));
        newComment.setCommenter(profileRepository.findById(commenterId).orElse(null));
        newComment.addObserver(new ObserverImpl(this.notificationRepository));
        newComment.notifyObservers();
        return commentRepository.save(newComment);
    }



}

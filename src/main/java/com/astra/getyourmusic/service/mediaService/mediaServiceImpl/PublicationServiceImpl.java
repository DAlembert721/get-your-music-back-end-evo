package com.astra.getyourmusic.service.mediaService.mediaServiceImpl;

import com.astra.getyourmusic.repository.userRepository.MusicianRepository;
import com.astra.getyourmusic.model.mediaSystem.Publication;
import com.astra.getyourmusic.repository.mediaRepository.PublicationRepository;
import com.astra.getyourmusic.service.mediaService.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;

    @Autowired
    private MusicianRepository musicianRepository;
    private final LocalDate today = LocalDate.now();

    @Override
    public List<Publication> getAllPublicationsByType(Long type) {
        return publicationRepository.findByType(type);
    }

    @Override
    public List<Publication> getAllPublicationsByMusicianId(Long musicianId) {
        return publicationRepository.findByMusicianId(musicianId);
    }

    @Override
    public List<Publication> getAllPublicationsByMusicianIdAndByTypeId(Long musicianId, Long type) {
        return publicationRepository.findByMusicianIdAndType(musicianId, type);
    }

    @Override
    public Publication save(Publication publication, Long musicianId) {
        Publication newPublication = new Publication();
        newPublication.setVideoUrl(publication.getVideoUrl());
        newPublication.setContent(publication.getContent());
        newPublication.setUpdateTime(today.toString());
        newPublication.setType(publication.getType());
        newPublication.setMusician(musicianRepository.findById(musicianId).orElse(null));
        return publicationRepository.save(newPublication);
    }


}

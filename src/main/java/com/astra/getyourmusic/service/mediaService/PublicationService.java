package com.astra.getyourmusic.service.mediaService;

import com.astra.getyourmusic.model.mediaSystem.*;

import java.util.List;

public interface PublicationService {
    List<Publication> getAllPublicationsByType(Long type);
    List<Publication> getAllPublicationsByMusicianId(Long musicianId);
    List<Publication> getAllPublicationsByMusicianIdAndByTypeId(Long musicianId, Long type);
    Publication save(Publication publication, Long musicianId);

}

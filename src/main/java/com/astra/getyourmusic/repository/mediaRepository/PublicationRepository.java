package com.astra.getyourmusic.repository.mediaRepository;

import com.astra.getyourmusic.model.mediaSystem.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByType(Long type);
    List<Publication> findByMusicianId(Long musicianId);
    List<Publication> findByMusicianIdAndType(Long musicianId, Long type);
}

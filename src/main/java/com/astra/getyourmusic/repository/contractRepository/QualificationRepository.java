package com.astra.getyourmusic.repository.contractRepository;

import com.astra.getyourmusic.model.contractSystem.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    List<Qualification> findByMusicianId(Long musicianId);
}

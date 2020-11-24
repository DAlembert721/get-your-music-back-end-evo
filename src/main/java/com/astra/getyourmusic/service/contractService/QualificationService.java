package com.astra.getyourmusic.service.contractService;

import com.astra.getyourmusic.model.contractSystem.Qualification;

import java.util.List;

public interface QualificationService {
    Qualification save(Qualification qualification, Long organizerId, Long contractId, Long musicianId);
    List<Qualification> getAllQualificationsByMusicianId(Long musicianId);
}

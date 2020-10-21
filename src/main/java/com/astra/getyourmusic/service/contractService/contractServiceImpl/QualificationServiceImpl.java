package com.astra.getyourmusic.service.contractService.contractServiceImpl;

import com.astra.getyourmusic.model.contractSystem.Qualification;
import com.astra.getyourmusic.repository.contractRepository.ContractRepository;
import com.astra.getyourmusic.repository.contractRepository.QualificationRepository;
import com.astra.getyourmusic.repository.userRepository.MusicianRepository;
import com.astra.getyourmusic.repository.userRepository.OrganizerRepository;
import com.astra.getyourmusic.service.contractService.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationServiceImpl implements QualificationService {
    @Autowired
    private QualificationRepository qualificationRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private MusicianRepository musicianRepository;

    @Override
    public Qualification save(Qualification qualification, Long organizerId, Long contractId, Long musicianId) {
        Qualification newQualification = new Qualification();
        newQualification.setText(qualification.getText());
        newQualification.setScore(qualification.getScore());
        newQualification.setContract(contractRepository.findById(contractId).orElse(null));
        newQualification.setOrganizer(organizerRepository.findById(organizerId).orElse(null));
        newQualification.setMusician(musicianRepository.findById(musicianId).orElse(null));
        return qualificationRepository.save(newQualification);
    }

    @Override
    public List<Qualification> getAllQualificationsByMusicianId(Long musicianId) {
        return qualificationRepository.findByMusicianId(musicianId);
    }
}

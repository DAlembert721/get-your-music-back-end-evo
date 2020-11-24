package com.astra.getyourmusic.service.userService.userServiceImpl;

import com.astra.getyourmusic.model.userSystem.Organizer;
import com.astra.getyourmusic.repository.userRepository.OrganizerRepository;
import com.astra.getyourmusic.service.userService.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerServiceImpl implements OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    @Override
    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    @Override
    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }
}

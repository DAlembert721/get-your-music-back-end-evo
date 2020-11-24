package com.astra.getyourmusic.service.userService;

import com.astra.getyourmusic.model.userSystem.Organizer;

import java.util.List;

public interface OrganizerService {
    List<Organizer> getAllOrganizers();
    Organizer getOrganizerById(Long id);
}

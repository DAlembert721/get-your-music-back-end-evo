package com.astra.getyourmusic.service.userService;

import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.model.userSystem.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ProfileService extends UserDetailsService {
    Profile getById(Long id);
    Profile getByEmail(String email);
    UserDetails loadUserByUsername(String email);
    Profile save(Profile profile, Long districtId);
    Profile update(Long id, Profile profile);
    List<Profile> getAllProfiles();
    List<Profile> getAllProfilesByName(String search);
}

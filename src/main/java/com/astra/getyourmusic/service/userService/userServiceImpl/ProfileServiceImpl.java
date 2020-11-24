package com.astra.getyourmusic.service.userService.userServiceImpl;

import com.astra.getyourmusic.repository.locationsRepository.DistrictRepository;
import com.astra.getyourmusic.repository.userRepository.ProfileRepository;
import com.astra.getyourmusic.model.userSystem.*;
import com.astra.getyourmusic.service.userService.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final LocalDate today = LocalDate.now();

    private final ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    public ProfileServiceImpl() {
        authorities.add(new SimpleGrantedAuthority("USER"));
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByEmail(email);
        if (profile == null){
            throw new UsernameNotFoundException(email);
        }
        return new User(profile.getEmail(), profile.getPassword(), authorities);
    }

    @Override
    @Transactional
    public Profile save(Profile profile, Long districtId){
        Profile newProfile = (profile.getType().equals("Musician"))?
                new Musician() : new Organizer();
        newProfile.setEmail(profile.getEmail());
        newProfile.setPassword(passwordEncoder.encode(profile.getPassword()));
        newProfile.setFirstName(profile.getFirstName());
        newProfile.setLastName(profile.getLastName());
        newProfile.setBirthDate(profile.getBirthDate());
        newProfile.setPhone(profile.getPhone());
        newProfile.setRegisterDate(today.toString());
        newProfile.setType((profile.getType().equals("Musician"))? "musician": "organizer");
        newProfile.setDistrict(districtRepository.findById(districtId).orElse(null));
        return profileRepository.save(newProfile);
    }

    @Override
    public Profile update(Long id, Profile profile) {
        Profile exist = profileRepository.findById(id).orElse(null);

        if (exist == null) {
            return null;
        }

        exist.setPhone(profile.getPhone());
        exist.setDescription(profile.getDescription());
        exist.setPhotoUrl(profile.getPhotoUrl());

        return profileRepository.save(exist);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public List<Profile> getAllProfilesByName(String search) {
        return profileRepository.findProfilesByFirstNameContainingOrLastNameContaining(search);
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public Profile getByEmail(String email){
        return profileRepository.findByEmail(email);
    }
}

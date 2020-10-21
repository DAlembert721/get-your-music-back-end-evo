package com.astra.getyourmusic.controller.userController;

import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.model.userSystem.Profile;
import com.astra.getyourmusic.resource.UserUpdateResource.UpdateProfileResource;
import com.astra.getyourmusic.resource.userResource.MusicianResource;
import com.astra.getyourmusic.resource.userResource.ProfileResource;
import com.astra.getyourmusic.resource.userSaveResource.SaveProfileResource;
import com.astra.getyourmusic.service.userService.ProfileService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProfileController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ProfileService profileService;

    @PostMapping("/districts/{districtId}/profiles")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProfileResource register(@RequestBody SaveProfileResource profile,
                            @PathVariable(name = "districtId") Long districtId){
        Profile exist = profileService.save(convertToEntity(profile), districtId);
        return convertToResource(exist);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("/profiles/{id}")
    public ProfileResource update(@RequestBody UpdateProfileResource profile,
                                  @PathVariable(name = "id") Long id) {
        Profile updated = profileService.update(id, convertToEntity(profile));
        return convertToResource(updated);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/profiles/{id}")
    public ProfileResource getProfile(@PathVariable(name = "id") Long id){
        return convertToResource(profileService.getById(id));
    }

    @GetMapping("/profiles")
    public List<ProfileResource> getAllProfiles()
    {
        List<Profile> profiles = profileService.getAllProfiles();
        return profiles.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/profiles/{search}/searchs")
    public List<ProfileResource> getAllProfilesByName(@PathVariable(name = "search") String search)
    {
        List<Profile> profiles = profileService.getAllProfilesByName(search);
        return profiles.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PostConstruct
    public void init(){
        mapper.addMappings(new PropertyMap<Profile, ProfileResource>() {

            @Override
            protected void configure() {
                map().setDistrictName(source.getDistrict().getName());
            }
        });
    }

    public ProfileResource convertToResource(Profile entity) {
        return mapper.map(entity, ProfileResource.class);

    }

    public Profile convertToEntity(SaveProfileResource resource) {
        return mapper.map(resource, Profile.class);
    }
    public Profile convertToEntity(UpdateProfileResource resource) {
        return mapper.map(resource, Profile.class);
    }
}
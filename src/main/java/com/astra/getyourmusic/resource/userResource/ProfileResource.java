package com.astra.getyourmusic.resource.userResource;

import lombok.Data;

@Data
public class ProfileResource {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phone;
    private String personalWeb;
    private String description;
    private String registerDate;
    private String districtName;
    private String type;
    private String photoUrl;
}

/*
    @PostConstruct
    public void init(){
        modelMapper.addMappings(new PropertyMap<Profile, ProfileResource>() {

            @Override
            protected void configure() {
                map().setDistrictName(source.getDistrict().getName());
            }
        });
    }
    //mapAutomatic
    public ProfileResource convertToResource(Profile profile) {
        return modelMapper.map(profile, ProfileResource.class);

    }

    public Profile convertToEntity(ProfileResource profileResource) {
        return modelMapper.map(profileResource, Profile.class);

    } */
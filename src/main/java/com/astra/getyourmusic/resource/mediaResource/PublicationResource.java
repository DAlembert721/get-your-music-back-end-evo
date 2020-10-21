package com.astra.getyourmusic.resource.mediaResource;

import com.astra.getyourmusic.model.mediaSystem.Publication;
import lombok.Data;

@Data
public class PublicationResource {
    private Long id;
    private String videoUrl;
    private String content;
    private String musicianName;
    private Long type;
}

/*
    @PostConstruct
    public void init(){
        modelMapper.addMappings(new PropertyMap<Publication, PublicationResource>() {

            @Override
            protected void configure() {
                map().setMusicianName(source.getMusician().getFirstName());
            }
        });
    }/*
    //mapAutomatic
*/
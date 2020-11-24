package com.astra.getyourmusic.controller.mediaController;

import com.astra.getyourmusic.model.mediaSystem.Publication;
import com.astra.getyourmusic.resource.mediaResource.PublicationResource;
import com.astra.getyourmusic.resource.mediaSaveResource.SavePublicationResource;
import com.astra.getyourmusic.service.mediaService.PublicationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PublicationController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PublicationService publicationService;

    @GetMapping("/publications/{type}")
    public List<PublicationResource> getAllPublicationsByType(@PathVariable(name = "type") Long type) {
        List<Publication> publications = publicationService.getAllPublicationsByType(type);
        return publications.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/musicians/{musicianId}/types/{type}/publications")
    public List<PublicationResource> getAllPublicationsByMusicianIdAndType(
            @PathVariable(name = "musicianId") Long musicianId,
            @PathVariable(name = "type") Long type)
    {
        List<Publication> publications = publicationService.getAllPublicationsByMusicianIdAndByTypeId(musicianId, type);
        return publications.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/musicians/{musicianId}/publications")
    public List<PublicationResource> getAllPublicationsByMusicianId(@PathVariable(name = "musicianId") Long musicianId)
    {
        List<Publication> publications = publicationService.getAllPublicationsByMusicianId(musicianId);
        return publications.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PostMapping("/musicians/{musicianId}/publications")
    public PublicationResource create(@RequestBody SavePublicationResource publication,
                              @PathVariable(name = "musicianId") Long musicianId)
    {
        Publication newPublication = publicationService.save(convertToEntity(publication), musicianId);
        return convertToResource(newPublication);
    }

    @PostConstruct
    public void init(){
        mapper.addMappings(new PropertyMap<Publication, PublicationResource>() {

            @Override
            protected void configure() {
                map().setMusicianName(source.getMusician().getFirstName());
            }
        });
    }

    public PublicationResource convertToResource(Publication entity) {
        return mapper.map(entity, PublicationResource.class);
    }

    public Publication convertToEntity(SavePublicationResource resource) {
        return mapper.map(resource, Publication.class);
    }
}

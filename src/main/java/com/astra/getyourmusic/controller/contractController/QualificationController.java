package com.astra.getyourmusic.controller.contractController;


import com.astra.getyourmusic.model.contractSystem.Qualification;
import com.astra.getyourmusic.model.mediaSystem.Comment;
import com.astra.getyourmusic.resource.contractResource.QualificationResource;
import com.astra.getyourmusic.resource.contractSaveResource.SaveQualificationResource;
import com.astra.getyourmusic.resource.mediaResource.CommentResource;
import com.astra.getyourmusic.service.contractService.QualificationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class QualificationController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private QualificationService qualificationService;
    @PostMapping("/organizers/{organizerId}/contracts/{contractId}/musicians/{musicianId}/qualifications")
    public QualificationResource save(@RequestBody SaveQualificationResource qualification,
                              @PathVariable(name = "organizerId") Long organizerId,
                              @PathVariable(name = "contractId") Long contractId,
                              @PathVariable(name = "musicianId") Long musicianId){
        Qualification newQualification = qualificationService.save(convertToEntity(qualification), organizerId, contractId, musicianId);
        return convertToResource(newQualification);
    }

    @GetMapping("/musicians/{musicianId}/qualifications")
    public List<QualificationResource> getAllQualificationsByMusicianId(@PathVariable(name = "musicianId") Long musicianId) {
        List<Qualification> qualifications = qualificationService.getAllQualificationsByMusicianId(musicianId);
        return qualifications.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PostConstruct
    public void init(){
        mapper.addMappings(new PropertyMap< Qualification, QualificationResource>() {

            @Override
            protected void configure() {
                map().setOrganizerName(source.getOrganizer().getFirstName());
            }
        });
    }

    private QualificationResource convertToResource(Qualification entity)
    {
        return mapper.map(entity, QualificationResource.class);
    }

    private Qualification convertToEntity(SaveQualificationResource resource)
    {
        return mapper.map(resource, Qualification.class);
    }
}

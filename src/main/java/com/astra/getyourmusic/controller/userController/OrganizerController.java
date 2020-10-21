package com.astra.getyourmusic.controller.userController;
import com.astra.getyourmusic.model.userSystem.Organizer;
import com.astra.getyourmusic.model.userSystem.Profile;
import com.astra.getyourmusic.resource.userResource.OrganizerResource;
import com.astra.getyourmusic.resource.userResource.ProfileResource;
import com.astra.getyourmusic.resource.userSaveResource.SaveProfileResource;
import com.astra.getyourmusic.service.userService.OrganizerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class OrganizerController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private OrganizerService organizerService;

    @GetMapping("/profiles/organizers")
    public List<OrganizerResource> getAllOrganizers() {
        List<Organizer> organizers = organizerService.getAllOrganizers();
        return organizers.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/organizers/{organizerId}")
    public OrganizerResource getOrganizerById(@PathVariable(name = "organizerId") Long organizerId)
    {
        return convertToResource(organizerService.getOrganizerById(organizerId));
    }

    @PostConstruct
    public void init(){
        mapper.addMappings(new PropertyMap<Organizer, OrganizerResource>() {

            @Override
            protected void configure() {
                map().setDistrictName(source.getDistrict().getName());
            }
        });
    }

    public OrganizerResource convertToResource(Organizer entity) {
        return mapper.map(entity, OrganizerResource.class);

    }
}

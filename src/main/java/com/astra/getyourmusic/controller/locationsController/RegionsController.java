package com.astra.getyourmusic.controller.locationsController;

import com.astra.getyourmusic.model.locations.City;
import com.astra.getyourmusic.model.locations.Region;
import com.astra.getyourmusic.resource.LocationsResource.CityResource;
import com.astra.getyourmusic.resource.LocationsResource.RegionResource;
import com.astra.getyourmusic.service.locationsService.RegionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RegionsController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RegionService regionService;

    @GetMapping("/regions")
    public List<RegionResource> getAllRegions()
    {
        List<Region> regions = regionService.getAllRegions();
        return regions.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    public RegionResource convertToResource(Region entity) {
        return mapper.map(entity, RegionResource.class);
    }
}

package com.astra.getyourmusic.controller.locationsController;

import com.astra.getyourmusic.model.locations.City;
import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.resource.LocationsResource.CityResource;
import com.astra.getyourmusic.resource.userResource.MusicianResource;
import com.astra.getyourmusic.service.locationsService.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CitiesController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CityService cityService;

    @GetMapping("/regions/{regionId}/cities")
    public List<CityResource> getAllCitiesByRegionId(@PathVariable(name = "regionId") Long regionId) {
        List<City> cities = cityService.getAllCitiesByRegionId(regionId);
        return cities.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    public CityResource convertToResource(City entity) {
        return mapper.map(entity, CityResource.class);
    }
}

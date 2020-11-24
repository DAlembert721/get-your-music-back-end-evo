package com.astra.getyourmusic.controller.locationsController;

import com.astra.getyourmusic.model.locations.City;
import com.astra.getyourmusic.model.locations.District;
import com.astra.getyourmusic.resource.LocationsResource.CityResource;
import com.astra.getyourmusic.resource.LocationsResource.DistrictResource;
import com.astra.getyourmusic.service.locationsService.DistrictService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DistrictsController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private DistrictService districtService;

    @GetMapping("/cities/{cityId}/districts")
    public List<DistrictResource> getAllDistrictsByCityId(@PathVariable(name = "cityId")  Long cityId) {
        List<District> districts = districtService.getAllDistrictsByCityId(cityId);
        return districts.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    public DistrictResource convertToResource(District entity) {
        return mapper.map(entity, DistrictResource.class);
    }
}

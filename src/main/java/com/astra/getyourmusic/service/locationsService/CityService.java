package com.astra.getyourmusic.service.locationsService;

import com.astra.getyourmusic.model.locations.City;

import java.util.List;

public interface CityService {
    List<City> getAllCitiesByRegionId(Long regionId);
}


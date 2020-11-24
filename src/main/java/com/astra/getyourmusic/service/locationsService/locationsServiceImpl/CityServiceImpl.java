package com.astra.getyourmusic.service.locationsService.locationsServiceImpl;

import com.astra.getyourmusic.model.locations.City;
import com.astra.getyourmusic.repository.locationsRepository.CityRepository;
import com.astra.getyourmusic.service.locationsService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCitiesByRegionId(Long regionId) {
        return cityRepository.findByRegionId(regionId);
    }
}

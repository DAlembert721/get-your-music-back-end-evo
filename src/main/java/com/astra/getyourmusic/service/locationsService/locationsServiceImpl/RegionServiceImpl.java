package com.astra.getyourmusic.service.locationsService.locationsServiceImpl;

import com.astra.getyourmusic.model.locations.Region;
import com.astra.getyourmusic.repository.locationsRepository.RegionRepository;
import com.astra.getyourmusic.service.locationsService.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> getAllRegions() {
        return regionRepository.findAll();
    }
}

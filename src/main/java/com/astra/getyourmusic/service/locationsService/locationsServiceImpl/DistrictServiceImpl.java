package com.astra.getyourmusic.service.locationsService.locationsServiceImpl;

import com.astra.getyourmusic.model.locations.District;
import com.astra.getyourmusic.repository.locationsRepository.DistrictRepository;
import com.astra.getyourmusic.service.locationsService.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<District> getAllDistrictsByCityId(Long cityId) {
        return districtRepository.findByCityId(cityId);
    }
}

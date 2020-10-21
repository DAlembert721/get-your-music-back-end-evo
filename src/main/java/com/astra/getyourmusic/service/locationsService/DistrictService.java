package com.astra.getyourmusic.service.locationsService;

import com.astra.getyourmusic.model.locations.District;

import java.util.List;

public interface DistrictService {
    List<District> getAllDistrictsByCityId(Long cityId);
}

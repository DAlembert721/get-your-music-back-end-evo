package com.astra.getyourmusic.repository.locationsRepository;

import com.astra.getyourmusic.model.locations.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByRegionId(Long regionId);
}

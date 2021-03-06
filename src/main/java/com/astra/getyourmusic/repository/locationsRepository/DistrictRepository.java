package com.astra.getyourmusic.repository.locationsRepository;

import com.astra.getyourmusic.model.locations.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findByCityId(Long cityId);
}

package com.astra.getyourmusic.repository.userRepository;

import com.astra.getyourmusic.model.userSystem.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicianRepository extends JpaRepository<Musician, Long> {
    List<Musician> findByDistrictId(Long districtId);
    @Query(value = "SELECT m FROM Musician m WHERE m.firstName = ?1 OR m.lastName = ?1")
    List<Musician> findMusiciansByFirstNameContainingOrLastNameContaining(String search);
}

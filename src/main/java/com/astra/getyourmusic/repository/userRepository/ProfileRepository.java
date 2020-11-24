package com.astra.getyourmusic.repository.userRepository;

import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.model.userSystem.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByEmail(String email);
    @Query(value = "SELECT p FROM Profile p WHERE p.firstName = ?1 OR p.lastName = ?1")
    List<Profile> findProfilesByFirstNameContainingOrLastNameContaining(String search);
}

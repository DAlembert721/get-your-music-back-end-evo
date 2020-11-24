package com.astra.getyourmusic.repository.mediaRepository;

import com.astra.getyourmusic.model.mediaSystem.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}

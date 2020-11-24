package com.astra.getyourmusic.service.mediaService;

import com.astra.getyourmusic.model.mediaSystem.*;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();
    List<Genre> getAllGenresByMusicianId(Long musicianId);
}

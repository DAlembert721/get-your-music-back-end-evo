package com.astra.getyourmusic.service.userService;

import com.astra.getyourmusic.model.userSystem.Musician;

import java.util.List;

public interface MusicianService {
    List<Musician> getAllMusicians();
    Musician getMusicianById(Long id);
    Musician assignMusicianGenre(Long musicianId, Long genreId);
    Musician unassignMusicianGenre(Long musicianId, Long genreId);
    List<Musician> getAllMusiciansByGenreId(Long genreId);
    Musician assignMusicianInstrument(Long musicianId, Long instrumentId);
    Musician unassignMusicianInstrument(Long musicianId, Long instrumentId);
    List<Musician> getAllMusiciansByInstrumentId(Long instrumentId);
    List<Musician> getAllMusiciansByDistrictId(Long districtId);
    List<Musician> getAllMusiciansByName(String search);
}

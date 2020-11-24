package com.astra.getyourmusic.service.mediaService.mediaServiceImpl;

import com.astra.getyourmusic.model.mediaSystem.*;
import com.astra.getyourmusic.model.userSystem.*;
import com.astra.getyourmusic.repository.mediaRepository.*;
import com.astra.getyourmusic.repository.userRepository.*;
import com.astra.getyourmusic.service.mediaService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MusicianRepository musicianRepository;

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> getAllGenresByMusicianId(Long musicianId) {
        return musicianRepository.findById(musicianId).map(Musician::getGenres).orElse(null);
    }
}

package com.astra.getyourmusic.service.userService.userServiceImpl;

import com.astra.getyourmusic.model.mediaSystem.Genre;
import com.astra.getyourmusic.model.mediaSystem.Instrument;
import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.repository.mediaRepository.GenreRepository;
import com.astra.getyourmusic.repository.mediaRepository.InstrumentRepository;
import com.astra.getyourmusic.repository.userRepository.MusicianRepository;
import com.astra.getyourmusic.service.userService.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicianServiceImpl implements MusicianService {
    @Autowired
    private MusicianRepository musicianRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private InstrumentRepository instrumentRepository;

    @Override
    public List<Musician> getAllMusicians() {
        return musicianRepository.findAll();
    }

    @Override
    public Musician getMusicianById(Long id) {
        return musicianRepository.findById(id).orElse(null);
    }

    @Override
    public Musician assignMusicianGenre(Long musicianId, Long genreId) {
        Genre genre = genreRepository.findById(genreId).orElse(null);
        return musicianRepository.findById(musicianId).map(musician -> {
            if(!musician.getGenres().contains(genre))
            {
                musician.getGenres().add(genre);
                return musicianRepository.save(musician);
            }
            return musician;
        }).orElse(null);
    }

    @Override
    public Musician unassignMusicianGenre(Long musicianId, Long genreId) {
        Genre genre = genreRepository.findById(genreId).orElse(null);
        return musicianRepository.findById(musicianId).map(musician -> {
            musician.getGenres().remove(genre);
            return musicianRepository.save(musician);
        }).orElse(null);
    }

    @Override
    public List<Musician> getAllMusiciansByGenreId(Long genreId) {
        return genreRepository.findById(genreId).map(Genre::getMusicians).orElse(null);
    }

    @Override
    public Musician assignMusicianInstrument(Long musicianId, Long instrumentId) {
        Instrument instrument = instrumentRepository.findById(instrumentId).orElse(null);
        return musicianRepository.findById(musicianId).map(musician -> {
            if(!musician.getInstruments().contains(instrument))
            {
                musician.getInstruments().add(instrument);
                return musicianRepository.save(musician);
            }
            return musician;
        }).orElse(null);
    }

    @Override
    public Musician unassignMusicianInstrument(Long musicianId, Long instrumentId) {
        Instrument instrument = instrumentRepository.findById(instrumentId).orElse(null);
        return musicianRepository.findById(musicianId).map(musician -> {
            musician.getInstruments().remove(instrument);
            return musicianRepository.save(musician);
        }).orElse(null);
    }

    @Override
    public List<Musician> getAllMusiciansByInstrumentId(Long instrumentId) {
        return instrumentRepository.findById(instrumentId).map(Instrument::getMusicians).orElse(null);
    }

    @Override
    public List<Musician> getAllMusiciansByDistrictId(Long districtId) {
        return musicianRepository.findByDistrictId(districtId);
    }

    @Override
    public List<Musician> getAllMusiciansByName(String search) {
        return musicianRepository.findMusiciansByFirstNameContainingOrLastNameContaining(search);
    }
}

package com.astra.getyourmusic.service.mediaService.mediaServiceImpl;

import com.astra.getyourmusic.model.mediaSystem.*;
import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.repository.mediaRepository.InstrumentRepository;
import com.astra.getyourmusic.repository.userRepository.MusicianRepository;
import com.astra.getyourmusic.service.mediaService.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentServiceImpl implements InstrumentService {
    @Autowired
    private InstrumentRepository instrumentRepository;
    @Autowired
    private MusicianRepository musicianRepository;

    @Override
    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    @Override
    public List<Instrument> getAllInstrumentsByMusicianId(Long musicianId) {
        return musicianRepository.findById(musicianId).map(Musician::getInstruments).orElse(null);
    }
}

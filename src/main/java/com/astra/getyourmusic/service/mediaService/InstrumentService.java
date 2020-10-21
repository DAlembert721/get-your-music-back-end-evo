package com.astra.getyourmusic.service.mediaService;

import com.astra.getyourmusic.model.mediaSystem.*;

import java.util.List;

public interface InstrumentService {
    List<Instrument> getAllInstruments();
    List<Instrument> getAllInstrumentsByMusicianId(Long musicianId);

}

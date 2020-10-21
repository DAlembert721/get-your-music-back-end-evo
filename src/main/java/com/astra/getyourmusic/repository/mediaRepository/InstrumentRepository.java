package com.astra.getyourmusic.repository.mediaRepository;

import com.astra.getyourmusic.model.mediaSystem.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}

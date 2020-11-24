package com.astra.getyourmusic.controller.mediaController;

import com.astra.getyourmusic.model.locations.City;
import com.astra.getyourmusic.model.mediaSystem.Instrument;
import com.astra.getyourmusic.resource.LocationsResource.CityResource;
import com.astra.getyourmusic.resource.mediaResource.InstrumentResource;
import com.astra.getyourmusic.service.mediaService.InstrumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class InstrumentController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private InstrumentService instrumentService;

    @GetMapping("/instruments")
    public List<InstrumentResource> getAllInstruments()
    {
        List<Instrument> instruments = instrumentService.getAllInstruments();
        return instruments.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/musicians/{musicianId}/instruments")
    public List<InstrumentResource> getAllInstrumentsByMusicianId(@PathVariable(name = "musicianId") Long musicianId)
    {
        List<Instrument> instruments = instrumentService.getAllInstrumentsByMusicianId(musicianId);
        return instruments.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    public InstrumentResource convertToResource(Instrument entity) {
        return mapper.map(entity, InstrumentResource.class);
    }
}

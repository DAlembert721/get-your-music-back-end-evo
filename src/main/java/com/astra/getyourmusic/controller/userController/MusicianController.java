package com.astra.getyourmusic.controller.userController;

import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.model.userSystem.Organizer;
import com.astra.getyourmusic.model.userSystem.Profile;
import com.astra.getyourmusic.resource.userResource.MusicianResource;
import com.astra.getyourmusic.resource.userResource.OrganizerResource;
import com.astra.getyourmusic.resource.userResource.ProfileResource;
import com.astra.getyourmusic.service.userService.MusicianService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MusicianController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private MusicianService musicianService;

    @GetMapping("/profiles/musicians")
    public List<MusicianResource> listMusicians() {
        List<Musician> musicians = musicianService.getAllMusicians();
        return musicians.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/musicians/{musicianId}")
    public MusicianResource getMusicianById(@PathVariable(name = "musicianId") Long musicianId)
    {
        return convertToResource(musicianService.getMusicianById(musicianId));
    }

    @GetMapping("/districts/{districtId}/musicians")
    public List<MusicianResource> getAllMusiciansByDistrictId(@PathVariable(name = "districtId") Long districtId)
    {
        List<Musician> musicians = musicianService.getAllMusiciansByDistrictId(districtId);
        return musicians.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/genres/{genreId}/musicians")
    public List<MusicianResource> getAllMusiciansByGenreId(@PathVariable(name = "genreId") Long genreId) {
        List<Musician> musicians = musicianService.getAllMusiciansByGenreId(genreId);
        return musicians.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PostMapping("/musicians/{musicianId}/genres/{genreId}")
    public MusicianResource assignMusicianGenre(@PathVariable(name = "musicianId") Long musicianId,
                                      @PathVariable(name = "genreId") Long genreId) {
        return convertToResource(musicianService.assignMusicianGenre(musicianId, genreId));
    }

    @DeleteMapping("/musicians/{musicianId}/genres/{genreId}")
    public MusicianResource unassignMusicianGenre(@PathVariable(name = "musicianId") Long musicianId,
                                        @PathVariable(name = "genreId") Long genreId) {
        return convertToResource(musicianService.unassignMusicianGenre(musicianId, genreId));
    }

    @GetMapping("/instruments/{instrumentId}/musicians")
    public List<MusicianResource> getAllMusiciansByInstrumentId(@PathVariable(name = "instrumentId") Long instrumentId) {
        List<Musician> musicians = musicianService.getAllMusiciansByInstrumentId(instrumentId);
        return musicians.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PostMapping("/musicians/{musicianId}/instruments/{instrumentId}")
    public MusicianResource assignMusicianInstrument(@PathVariable(name = "musicianId") Long musicianId,
                                        @PathVariable(name = "instrumentId") Long instrumentId) {
        return convertToResource(musicianService.assignMusicianInstrument(musicianId, instrumentId));
    }

    @DeleteMapping("/musicians/{musicianId}/instruments/{instrumentId}")
    public MusicianResource unassignMusicianInstrument(@PathVariable(name = "musicianId") Long musicianId,
                                          @PathVariable(name = "instrumentId") Long instrumentId) {
        return convertToResource(musicianService.unassignMusicianInstrument(musicianId, instrumentId));
    }

    @GetMapping("/musicians/{search}/searchs")
    public List<MusicianResource> getAllMusiciansByName(@PathVariable(name = "search") String search)
    {
        List<Musician> musicians = musicianService.getAllMusiciansByName(search);
        return musicians.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PostConstruct
    public void init(){
        mapper.addMappings(new PropertyMap<Musician, MusicianResource>() {

            @Override
            protected void configure() {
                map().setDistrictName(source.getDistrict().getName());
            }
        });
    }

    public MusicianResource convertToResource(Musician entity) {
        return mapper.map(entity, MusicianResource.class);
    }
}

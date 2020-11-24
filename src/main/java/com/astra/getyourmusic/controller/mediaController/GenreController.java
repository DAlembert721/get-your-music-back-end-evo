package com.astra.getyourmusic.controller.mediaController;

import com.astra.getyourmusic.model.locations.City;
import com.astra.getyourmusic.model.mediaSystem.Genre;
import com.astra.getyourmusic.resource.LocationsResource.CityResource;
import com.astra.getyourmusic.resource.mediaResource.GenreResource;
import com.astra.getyourmusic.service.mediaService.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GenreController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public List<GenreResource> getAllGenres()
    {
        List<Genre> genres = genreService.getAllGenres();
        return genres.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/musicians/{musicianId}/genres")
    public List<Genre> getAllGenresByMusicianId(@PathVariable(name = "musicianId") Long musicianId)
    {
        return genreService.getAllGenresByMusicianId(musicianId);
    }

    public GenreResource convertToResource(Genre entity) {
        return mapper.map(entity, GenreResource.class);
    }
}

package com.filmrestapi.filmapi.controller;

import com.filmrestapi.filmapi.Service.FilmService;
import com.filmrestapi.filmapi.dto.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {

    @Autowired
    FilmService filmService;

    @PostMapping("/NewFilm")
    public void newFilm(@RequestBody FilmDto filmDto){
        filmService.saveNewFilm(new FilmDto(filmDto.getName(), filmDto.getYear(), filmDto.getYonetmen()));
    }

    @GetMapping("/AllFilm")
    public List<FilmDto> getAllFilm(){
        return filmService.getAll();
    }

    @GetMapping("/Film/{FilmID}")
    public List<FilmDto>getFilmID(@PathVariable("FilmID") Integer FilmID){
        return filmService.getFilmID(FilmID);
    }
}
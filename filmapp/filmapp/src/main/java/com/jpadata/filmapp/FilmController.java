package com.jpadata.filmapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class FilmController {

    @Autowired
    Filmm filmm;

    @GetMapping("/film")
    public List<Film> getAllFilms(){
        return filmm.findAll();
    }

    @GetMapping("/film/{Film_id}")
    public Optional<Film> getFilms(@PathVariable("Film_id") int Film_id) {
        return filmm.findById(Film_id);
    }

    @PostMapping("/newFilms")
    public void addFilm(@RequestBody Film film){
        filmm.save(film);
    }

}

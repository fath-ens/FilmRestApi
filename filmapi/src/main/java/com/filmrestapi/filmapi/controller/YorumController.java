package com.filmrestapi.filmapi.controller;

import com.filmrestapi.filmapi.Service.YorumService;
import com.filmrestapi.filmapi.dto.YorumDto;
import com.filmrestapi.filmapi.dto.YorumDtoGet;
import com.filmrestapi.filmapi.entity.Film;
import com.filmrestapi.filmapi.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class YorumController {
    @Autowired
    YorumService yorumService;

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/AllYorum")
    public List<YorumDto> getAllYorum(){
        return yorumService.getAll();
    }

    @GetMapping("/Yorum/{FilmID}")
    public List<YorumDtoGet>getFilmID(@PathVariable("FilmID") Integer FilmID){
        Optional<Film> film = filmRepository.findById(FilmID);
        return yorumService.getFilmID(film);
    }

    @PostMapping("/NewYorum")
    public void newYorum(@RequestBody YorumDto yorum){
        yorumService.saveNewYorum(new YorumDto(yorum.getFid(), yorum.getUser(), yorum.getIcerig()));
    }
}
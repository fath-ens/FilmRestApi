package com.filmrestapi.filmapi.controller;

import com.filmrestapi.filmapi.Service.YorumService;
import com.filmrestapi.filmapi.dto.YorumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class YorumController {
    @Autowired
    YorumService yorumService;

    @GetMapping("/AllYorum")
    public List<YorumDto> getAllYorum(){
        return yorumService.getAll();
    }

    @GetMapping("/Yorum/{FilmID}")
    public List<YorumDto>getFilmID(@PathVariable("FilmID") Integer FilmID){
        return yorumService.getFilmID(FilmID);
    }

    @PostMapping("/NewYorum")
    public void newYorum(@RequestBody YorumDto yorumDto){
        yorumService.saveNewYorum(new YorumDto(yorumDto.getFid(), yorumDto.getUser(), yorumDto.getIcerig()));
    }
}
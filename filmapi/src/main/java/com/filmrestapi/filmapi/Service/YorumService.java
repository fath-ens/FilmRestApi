package com.filmrestapi.filmapi.Service;

import com.filmrestapi.filmapi.dto.YorumDto;
import com.filmrestapi.filmapi.dto.YorumDtoGet;
import com.filmrestapi.filmapi.entity.Film;
import com.filmrestapi.filmapi.entity.Yorum;
import com.filmrestapi.filmapi.repository.FilmRepository;
import com.filmrestapi.filmapi.repository.YorumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class YorumService {
    @Autowired
    YorumRepository yorumRepository;

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    FilmService filmService;
    public List<YorumDto> getAll() {
        List<Yorum>YorumList = yorumRepository.findAll();
        return (List<YorumDto>) YorumList.stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public YorumDto fromEntityToDto(Yorum yorum) {
        YorumDto yorumDto = new YorumDto(yorum.getFid().getId(),yorum.getUser(), yorum.getIcerig());
        return yorumDto;
    }

    public YorumDtoGet fromEntityToDtoGet(Yorum yorum) {
        YorumDtoGet yorumDto = new YorumDtoGet(yorum.getUser(), yorum.getIcerig());
        return yorumDto;
    }

    public List<YorumDtoGet>getFilmID(Optional<Film> film){
        List<Yorum> yorumlar = film.get().getYorumlar();
        return (List<YorumDtoGet>) yorumlar.stream()
                .map(this::fromEntityToDtoGet)
                .collect(Collectors.toList());
    }

    public void saveNewYorum(YorumDto yorumDto){
        Yorum yorum = fromDtoToEntity(yorumDto);
        yorumRepository.save(yorum);
    }

    public Yorum fromDtoToEntity(YorumDto yorumDto){
        Film film = filmRepository.findById(yorumDto.getFid()).get();
        Yorum yorum = new Yorum(film, yorumDto.getUser(), yorumDto.getIcerig());
        return yorum;
    }
}

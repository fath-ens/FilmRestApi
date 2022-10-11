package com.filmrestapi.filmapi.Service;

import com.filmrestapi.filmapi.dto.FilmDto;
import com.filmrestapi.filmapi.entity.Film;
import com.filmrestapi.filmapi.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public List<FilmDto>getAll () {
        List<Film>FilmList = filmRepository.findAll();
        return (List<FilmDto>) FilmList.stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }
    public FilmDto fromEntityToDto(Film film) {
        FilmDto filmDto = new FilmDto(film.getName(), film.getYear(), film.getYonetmen());
        return filmDto;
    }

    public List<FilmDto>getFilmID(Integer FilmID){
        Optional<Film> FilmList = filmRepository.findById(FilmID);
        return (List<FilmDto>) FilmList.stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public void saveNewFilm(FilmDto filmDto){
        Film film = fromDtoToEntity(filmDto);
        filmRepository.save(film);
    }

    public Film fromDtoToEntity(FilmDto filmDto){
        Film film = new Film(filmDto.getName(), filmDto.getYear(), filmDto.getYonetmen());
        return film;
    }
}

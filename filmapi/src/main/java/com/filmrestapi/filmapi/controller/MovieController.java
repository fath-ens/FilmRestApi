package com.filmrestapi.filmapi.controller;

import com.filmrestapi.filmapi.Service.MovieService;
import com.filmrestapi.filmapi.dto.MovieDto;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.MapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final MapStructMapper mapStructMapper;

    @PostMapping("/NewMovie")
    public void newMovie(@RequestBody MovieDto movieDto){
        movieService.saveNewMovie(mapStructMapper.movieDtoToMovie(movieDto));
    }

    @GetMapping("/AllMovie")
    public List<MovieDto> getAllMovie(){
        List<Movie> movies = movieService.getAll();
        List<MovieDto> movieDtos = new ArrayList<MovieDto>(movies.size());
        for (Movie movie:movies){
            movieDtos.add(mapStructMapper.movieToMovieDto(movie));
        }
        return movieDtos;
    }

    @GetMapping("/Movie/{FilmID}")
    public MovieDto getMovieID(@PathVariable("FilmID") Integer filmId){
        Movie movie = movieService.getMovieID(filmId);
        return mapStructMapper.movieToMovieDto(movie);
    }
}
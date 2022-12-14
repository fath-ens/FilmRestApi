package com.filmrestapi.filmapi.controller;

import com.filmrestapi.filmapi.Service.MovieService;
import com.filmrestapi.filmapi.dto.Existing;
import com.filmrestapi.filmapi.dto.MovieDto;
import com.filmrestapi.filmapi.dto.New;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.mapped.MapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class MovieController {

    private final MovieService movieService;
    private final MapStructMapper mapStructMapper;

    @PostMapping("/NewMovie")
    public String newMovie(@Validated(New.class) @RequestBody MovieDto movieDto){
        Movie movie = mapStructMapper.movieDtoToMovie(movieDto);
        movieService.saveNewMovie(movie);
        return "Save to movies";
    }

    @GetMapping("/AllMovies")
    @Validated
    public List<MovieDto> getAllMovie(){
        List<Movie> movies = movieService.getAll();
        List<MovieDto> movieDtos = new ArrayList<MovieDto>(movies.size());
        for (Movie movie:movies){
            movieDtos.add(mapStructMapper.movieToMovieDto(movie));
        }
        return movieDtos;
    }

    @GetMapping("/Movie/{FilmID}")
    @Validated
    public MovieDto getMovieID(@PathVariable("FilmID") Integer filmId){
        Movie movie = movieService.getMovieID(filmId);
        return mapStructMapper.movieToMovieDto(movie);
    }

    @PutMapping("/Movie/{MovieID}")
    public void editMovie(@Validated(Existing.class) @RequestBody MovieDto movieDto, @PathVariable("MovieID") Integer movieID){
        movieService.editMovie(mapStructMapper.movieDtoToMovie(movieDto), movieID);
    }

}
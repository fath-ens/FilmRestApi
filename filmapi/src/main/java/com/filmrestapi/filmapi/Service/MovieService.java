package com.filmrestapi.filmapi.Service;


import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public List<Movie>getAll () {
        return movieRepository.findAll();
    }
    public Movie getMovieID(Integer id){
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no movie with the searched id "));
    }
    public void saveNewMovie(Movie movie){
        movieRepository.save(movie);
    }
}

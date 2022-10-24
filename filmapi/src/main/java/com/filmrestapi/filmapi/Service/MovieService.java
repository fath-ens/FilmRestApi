package com.filmrestapi.filmapi.Service;


import com.filmrestapi.filmapi.dto.MovieDto;
import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
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

    public void editMovie(Movie movie, Integer movieID) {
        movieRepository.findById(movieID).map(
                oldmovie ->{
                    oldmovie.setYear(movie.getYear());
                    oldmovie.setName(movie.getName());
                    oldmovie.setDirector(movie.getDirector());
                    movieRepository.save(oldmovie);
                    return "Movie be edit.";
                }).orElseGet(()->{
            movieRepository.save(movie);
            return "New Movie saved";
        });
    }

}

package com.filmrestapi.filmapi.mapped;

import com.filmrestapi.filmapi.dto.CommentDto;
import com.filmrestapi.filmapi.dto.MovieDto;
import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
@RequiredArgsConstructor
public class MapStructMapperImpl implements MapStructMapper{

    private final MovieRepository movieRepository;
    @Override
    public Movie movieDtoToMovie(MovieDto movieDto) {
        if (movieDto == null){
            return null;
        }
        Movie movie = new Movie();
        movie.setName(movieDto.getName());
        movie.setYear(movieDto.getYear());
        movie.setDirector(movieDto.getDirector());
        return movie;
    }

    @Override
    public MovieDto movieToMovieDto(Movie movie) {
        if (movie == null){
            return null;
        }
        MovieDto movieDto = new MovieDto();
        movieDto.setName(movie.getName());
        movieDto.setYear(movie.getYear());
        movieDto.setDirector(movie.getDirector());
        return movieDto;
    }

    @Override
    public java.util.List<MovieDto> movieToMovieDtoList(java.util.List<Movie> movies) {
        if (movies == null){
            return null;
        }
        List<MovieDto> movieDtos = new ArrayList<MovieDto>(movies.size());
        for (Movie movie : movies){
            movieDtos.add(movieToMovieDto(movie));
        }
        return movieDtos;
    }


    @Override
    public Comment commentDtoToComment(CommentDto commentDto) {
        if (commentDto == null){
            return null;
        }
        Comment comment = new Comment();
        comment.setFid(movieRepository.findById(commentDto.getFid()).orElseThrow(() -> new RuntimeException("There is no movie with the searched id")));
        comment.setUser(commentDto.getUser());
        comment.setMsg(commentDto.getMsg());
        return comment;
    }

    @Override
    public CommentDto commentToCommentDto(Comment comment) {
        if (comment == null){
            return null;
        }
        CommentDto commentDto = new CommentDto();
        commentDto.setFid(comment.getFid().getId());
        commentDto.setUser(comment.getUser());
        commentDto.setMsg(comment.getMsg());

        return commentDto;
    }

    @Override
    public List<CommentDto> commentToCommentDtoList(List<Comment> comments) {
        if (comments == null){
            return null;
        }
        List<CommentDto> commentDtos = new ArrayList<CommentDto>(comments.size());
        for (Comment comment : comments){
            commentDtos.add(commentToCommentDto(comment));
        }
        return commentDtos;
    }

}

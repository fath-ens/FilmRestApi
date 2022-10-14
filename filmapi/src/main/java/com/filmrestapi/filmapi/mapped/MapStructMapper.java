package com.filmrestapi.filmapi.mapped;

import com.filmrestapi.filmapi.dto.CommentDto;
import com.filmrestapi.filmapi.dto.MovieDto;
import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    Movie movieDtoToMovie(MovieDto movieDto);

    List<MovieDto> movieToMovieDtoList(List<Movie> movies);

    MovieDto movieToMovieDto(Movie movie);

    Comment commentDtoToComment(CommentDto commentDto);

    CommentDto commentToCommentDto(Comment comment);

    List<CommentDto> commentToCommentDtoList(List<Comment> comments);

}

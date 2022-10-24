package com.filmrestapi.filmapi.mapped;

import com.filmrestapi.filmapi.dto.CommentDto;
import com.filmrestapi.filmapi.dto.MovieDto;
import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-24T13:23:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl extends MapStructMapper {

    @Override
    public Movie movieDtoToMovie(MovieDto movieDto) {
        if ( movieDto == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setName( movieDto.getName() );
        movie.setYear( movieDto.getYear() );
        movie.setDirector( movieDto.getDirector() );

        return movie;
    }

    @Override
    public MovieDto movieToMovieDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MovieDto movieDto = new MovieDto();

        movieDto.setId( movie.getId() );
        movieDto.setName( movie.getName() );
        movieDto.setYear( movie.getYear() );
        movieDto.setDirector( movie.getDirector() );

        return movieDto;
    }

    @Override
    public CommentDto commentToCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setId( comment.getId() );
        commentDto.setUser( comment.getUser() );
        commentDto.setMsg( comment.getMsg() );

        commentToCommentDtoAfter( comment, commentDto );

        return commentDto;
    }

    @Override
    public Comment commentDtoToComment(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setUser( commentDto.getUser() );
        comment.setMsg( commentDto.getMsg() );

        commentDtoToCommentAfter( commentDto, comment );

        return comment;
    }
}

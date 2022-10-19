package com.filmrestapi.filmapi.mapped;

import com.filmrestapi.filmapi.Service.MovieService;
import com.filmrestapi.filmapi.dto.CommentDto;
import com.filmrestapi.filmapi.dto.MovieDto;
import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.repository.MovieRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import javax.inject.Inject;

@Mapper(componentModel = "spring")
public abstract class MapStructMapper {

    @Inject
    MovieService movieService;

    public abstract Movie movieDtoToMovie(MovieDto movieDto);

    public abstract MovieDto movieToMovieDto(Movie movie);


    @Mapping(target = "fid", ignore = true)
    public abstract CommentDto commentToCommentDto(Comment comment);

    @Mapping(target = "fid", ignore = true)
    public abstract Comment commentDtoToComment(CommentDto commentDto);

    @AfterMapping
    public void commentToCommentDtoAfter(Comment comment, @MappingTarget CommentDto commentDto){
        commentDto.setFid(comment.getFid().getId());
    }

    @AfterMapping
    public void commentDtoToCommentAfter(CommentDto commentDto, @MappingTarget Comment comment){
        comment.setFid(movieService.getMovieID(commentDto.getFid()));
    }

}

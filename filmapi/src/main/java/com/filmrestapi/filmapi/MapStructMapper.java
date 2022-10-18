package com.filmrestapi.filmapi;

import com.filmrestapi.filmapi.dto.CommentDto;
import com.filmrestapi.filmapi.dto.MovieDto;
import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.repository.MovieRepository;

import org.mapstruct.*;


import java.util.List;

@Mapper(componentModel = "spring")
public abstract class MapStructMapper {
   public abstract Movie movieDtoToMovie(MovieDto movieDto);
   public abstract MovieDto movieToMovieDto(Movie movie);

   @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
   public abstract Movie updateMovieFromMovieDto(MovieDto movieDto, @MappingTarget Movie movie);

   public abstract Comment commentDtoToComment(CommentDto commentDto);

   public abstract CommentDto commentToCommentDto(Comment comment);

   @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
   public abstract Comment updateCommentFromCommentDto(CommentDto commentDto, @MappingTarget Comment comment);

 /* @Inject
  private MovieRepository movieRepository;
*/


/*
    @AfterMapping
    public void afterCommentToCommentDto(Comment comment, @MappingTarget CommentDto commentDto ){
        commentDto.setFid(comment.getFid().getId());
    }

    @AfterMapping
    public void afterCommentDtoToComment(CommentDto commentDto, @MappingTarget Comment comment){
        comment.setFid(movieRepository.findById(commentDto.getFid()).orElseThrow(()-> new RuntimeException("There is no movie with the searched id")));
    }
*/
}

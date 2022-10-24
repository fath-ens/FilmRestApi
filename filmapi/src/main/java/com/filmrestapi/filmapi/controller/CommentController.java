package com.filmrestapi.filmapi.controller;

import com.filmrestapi.filmapi.Service.CommentService;
import com.filmrestapi.filmapi.Service.MovieService;
import com.filmrestapi.filmapi.dto.CommentDto;
import com.filmrestapi.filmapi.dto.Existing;
import com.filmrestapi.filmapi.dto.MovieDto;
import com.filmrestapi.filmapi.dto.New;
import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.mapped.MapStructMapper;
import com.filmrestapi.filmapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class CommentController {
    private final CommentService commentService;
    private final MovieService movieService;
    private final MapStructMapper mapStructMapper;

    @GetMapping("/AllComment")
    public List<CommentDto> getAllComment(){
        List<Comment> comments = commentService.getAll();
        List<CommentDto> commentDtos = new ArrayList<CommentDto>(comments.size());
        for (Comment comment:comments){
            commentDtos.add(mapStructMapper.commentToCommentDto(comment));
        }
        return commentDtos;
    }

    @GetMapping("/Comment/{FilmID}")
    public List<CommentDto> getMovieID(@PathVariable("FilmID") Integer filmId){
        Movie movie = movieService.getMovieID(filmId);
        List<Comment> comments = commentService.getMovieID(movie);
        List<CommentDto> commentDtos = new ArrayList<CommentDto>(comments.size());
        for (Comment comment:comments){
            commentDtos.add(mapStructMapper.commentToCommentDto(comment));
        }
        return commentDtos;
    }

    @PostMapping("/NewComment")
    public RuntimeException newComment(@Validated(New.class) @RequestBody CommentDto commentDto){
        commentService.saveNewComment(mapStructMapper.commentDtoToComment(commentDto));
        return new RuntimeException("Save to comment");

    }

    @PutMapping("/Comment/{CommentID}")
    @Validated
    public void editMovie(@Validated(Existing.class) @RequestBody CommentDto commentDto, @PathVariable("CommentID") Integer commentID){
        commentService.editComment(mapStructMapper.commentDtoToComment(commentDto), commentID);

    }
}
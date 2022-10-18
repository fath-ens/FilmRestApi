package com.filmrestapi.filmapi.controller;

import com.filmrestapi.filmapi.Service.CommentService;
import com.filmrestapi.filmapi.dto.CommentDto;
import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.MapStructMapper;
import com.filmrestapi.filmapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final MovieRepository movieRepository;
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
        Movie movie = movieRepository.findById(filmId).orElseThrow(()->new RuntimeException("There is no movie with the searched id"));
        List<Comment> comments = commentService.getMovieID(movie);
        List<CommentDto> commentDtos = new ArrayList<CommentDto>(comments.size());
        for (Comment comment:comments){
            commentDtos.add(mapStructMapper.commentToCommentDto(comment));
        }
        return commentDtos;
    }

    @PostMapping("/NewComment")
    public void newComment(@RequestBody CommentDto commentDto){
        commentService.saveNewComment(mapStructMapper.commentDtoToComment(commentDto));
    }
}
package com.filmrestapi.filmapi.controller;

import com.filmrestapi.filmapi.Service.CommentService;
import com.filmrestapi.filmapi.dto.CommentDto;
import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.mapped.MapStructMapper;
import com.filmrestapi.filmapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        return mapStructMapper.commentToCommentDtoList(comments);
    }

    @GetMapping("/Comment/{FilmID}")
    public List<CommentDto> getMovieID(@PathVariable("FilmID") Integer filmId){
        Movie movie = movieRepository.findById(filmId).orElseThrow(()->new RuntimeException("There is no movie with the searched id"));
        return mapStructMapper.commentToCommentDtoList(commentService.getMovieID(movie));
    }

    @PostMapping("/NewComment")
    public void newComment(@RequestBody CommentDto commentDto){
        commentService.saveNewComment(mapStructMapper.commentDtoToComment(commentDto));
    }
}
package com.filmrestapi.filmapi.Service;


import com.filmrestapi.filmapi.entity.Comment;
import com.filmrestapi.filmapi.entity.Movie;
import com.filmrestapi.filmapi.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }
    public List<Comment> getMovieID(Movie movie){
        return movie.getComment();
    }

    public void saveNewComment(Comment comment){
        commentRepository.save(comment);
    }
}

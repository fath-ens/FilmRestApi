package com.filmrestapi.filmapi.repository;


import com.filmrestapi.filmapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
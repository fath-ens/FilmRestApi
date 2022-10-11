package com.filmrestapi.filmapi.repository;

import com.filmrestapi.filmapi.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
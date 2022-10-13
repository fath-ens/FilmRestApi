package com.filmrestapi.filmapi.repository;

import com.filmrestapi.filmapi.entity.Film;
import com.filmrestapi.filmapi.entity.Yorum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface YorumRepository extends JpaRepository<Yorum, Integer> {
    List<Yorum> findByfid(Optional<Film> fid);
}
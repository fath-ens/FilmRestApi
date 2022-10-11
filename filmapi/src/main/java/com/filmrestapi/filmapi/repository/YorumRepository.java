package com.filmrestapi.filmapi.repository;

import com.filmrestapi.filmapi.entity.Yorum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YorumRepository extends JpaRepository<Yorum, Integer> {
    List<Yorum> findByfid(Integer fid);
}
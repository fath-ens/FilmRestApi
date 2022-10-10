package com.jpadata.filmapp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface Yorumm extends JpaRepository<Yorum, Integer> {
    List<Yorum> findByfid(int f_id);
}

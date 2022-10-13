package com.filmrestapi.filmapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int year;
    private String yonetmen;

    @OneToMany(mappedBy = "fid")
    private List<Yorum> yorumlar;

    public Film(String name, int year, String yonetmen) {
        this.name = name;
        this.year = year;
        this.yonetmen = yonetmen;
    }

    public Film() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public List<Yorum> getYorumlar() {
        return yorumlar;
    }
}
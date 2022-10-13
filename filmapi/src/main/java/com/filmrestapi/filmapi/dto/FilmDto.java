package com.filmrestapi.filmapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FilmDto implements Serializable {
    private String name;
    private int year;
    private String yonetmen;

    public FilmDto(String name, int year, String yonetmen) {
        this.name = name;
        this.year = year;
        this.yonetmen = yonetmen;
    }

    public FilmDto() {
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


}
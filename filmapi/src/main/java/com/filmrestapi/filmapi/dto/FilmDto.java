package com.filmrestapi.filmapi.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class FilmDto implements Serializable {
    private String name;
    private int year;
    private String yonetmen;

    public FilmDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        this.yonetmen = yonetmen;
    }

    public FilmDto(String name, int year, String yonetmen) {
        this.name = name;
        this.year = year;
        this.yonetmen = yonetmen;
    }

    @Override
    public String toString() {
        return "FilmDto{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", yonetmen='" + yonetmen + '\'' +
                '}';
    }
}
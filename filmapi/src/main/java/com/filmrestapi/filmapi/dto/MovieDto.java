package com.filmrestapi.filmapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto implements Serializable {

    @NotNull(groups = Existing.class)
    @Null(groups = New.class)
    private Integer id;

    @NotEmpty
    @Size(max = 500)
    private String name;

    @NotNull
    @Min(1950)
    @Max(2022)
    private int year;


    @NotEmpty
    @Size(max = 500)
    private String director;

    public MovieDto(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }
}
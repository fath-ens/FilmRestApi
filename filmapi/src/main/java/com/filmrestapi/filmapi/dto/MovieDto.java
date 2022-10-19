package com.filmrestapi.filmapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto implements Serializable {

    @NotEmpty
    @Size(max = 500, message = " Film name should have at max 500 characters")
    private String name;

    @NotNull
    @Min(1950)
    @Max(2022)
    private int year;


    @NotEmpty
    @Size(max = 500, message = " Director name should have at max 500 characters")
    private String director;
}